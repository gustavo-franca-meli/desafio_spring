package com.mercadolibre.desafiospring.aplication.useCase.impl;

import com.mercadolibre.desafiospring.aplication.response.UserResponse;
import com.mercadolibre.desafiospring.aplication.response.FollowersCountResponse;
import com.mercadolibre.desafiospring.aplication.response.FollowersListResponse;
import com.mercadolibre.desafiospring.aplication.response.FollowingListResponse;
import com.mercadolibre.desafiospring.domain.exception.UserIsAlreadyFollowingException;
import com.mercadolibre.desafiospring.aplication.useCase.UserUseCase;
import com.mercadolibre.desafiospring.domain.exception.UserNotFound;
import com.mercadolibre.desafiospring.domain.factories.UserFactory;
import com.mercadolibre.desafiospring.infrastructure.UserRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserUseCaseImpl implements UserUseCase {
    private UserRepository userRepository;

    public UserUseCaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void follow(String userId, String userIdToFollow) throws Exception {
        var user = userRepository.find(UserFactory.create(userId));
        var userToFollow = userRepository.find(UserFactory.create(userIdToFollow));

        if(user == null)throw new IllegalArgumentException("User does not exist");
        if(userToFollow == null)throw  new IllegalArgumentException("following user does not exist");

        if(!user.follow(userToFollow))throw new UserIsAlreadyFollowingException(user, userToFollow);
        userRepository.save(user);
        userRepository.save(userToFollow);



    }

    @Override
    public FollowersCountResponse followersCount(String userId) throws UserNotFound {
        var user = userRepository.find(UserFactory.create(userId));
        if(user == null)throw new UserNotFound(userId);
        return new FollowersCountResponse(user.getId(),user.getName(),user.followersCount());
    }
    @Override
    public FollowersListResponse followersList(String userId) throws Exception {
        var user = userRepository.find(UserFactory.create(userId));
        if(user == null)throw new UserNotFound(userId);

        var followersOfUser = userRepository.findAllFollowers(user);

        var followerOfUserResponse = followersOfUser.stream().map(UserResponse::new).collect(Collectors.toList());

        return new FollowersListResponse(user.getId(),user.getName(),followerOfUserResponse);
    }
    @Override
    public FollowingListResponse followingList(String userId) throws Exception {
        var user = userRepository.find(UserFactory.create(userId));
        if(user == null)throw new UserNotFound(userId);

        var followersOfUser = userRepository.findAllFollowing(user);

        var followerOfUserResponse = followersOfUser.stream().map(UserResponse::new).collect(Collectors.toList());

        return new FollowingListResponse(user.getId(),user.getName(),followerOfUserResponse);
    }
}

