package com.mercadolibre.desafiospring.aplication.useCase.impl;

import com.mercadolibre.desafiospring.aplication.response.UserResponse;
import com.mercadolibre.desafiospring.aplication.response.FollowersCountResponse;
import com.mercadolibre.desafiospring.aplication.response.FollowersListResponse;
import com.mercadolibre.desafiospring.aplication.response.FollowingListResponse;
import com.mercadolibre.desafiospring.domain.Seller;
import com.mercadolibre.desafiospring.domain.exception.UserIsAlreadyFollowingException;
import com.mercadolibre.desafiospring.aplication.useCase.UserUseCase;
import com.mercadolibre.desafiospring.domain.exception.UserNotFound;
import com.mercadolibre.desafiospring.domain.factories.SellerFactory;
import com.mercadolibre.desafiospring.domain.factories.UserFactory;
import com.mercadolibre.desafiospring.infrastructure.SellerRepository;
import com.mercadolibre.desafiospring.infrastructure.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserUseCaseImpl implements UserUseCase {
    private UserRepository userRepository;
    private SellerRepository sellerRepository;

    public UserUseCaseImpl(UserRepository userRepository, SellerRepository sellerRepository) {
        this.userRepository = userRepository;
        this.sellerRepository = sellerRepository;
    }

    @Override
    public void follow(String userId, String userIdToFollow) throws Exception {
        var user = userRepository.find(UserFactory.create(userId));
        var sellerToFollow = sellerRepository.find(SellerFactory.create(userIdToFollow));

        if(user == null)throw new IllegalArgumentException("User does not exist");
        if(sellerToFollow == null)throw  new IllegalArgumentException("following seller does not exist");


        if(!user.follow(sellerToFollow))throw new UserIsAlreadyFollowingException(user, sellerToFollow);
        userRepository.save(user);
        sellerRepository.save(sellerToFollow);
    }

    @Override
    public FollowersCountResponse followersCount(String userId) throws UserNotFound {
        var seller = sellerRepository.find(SellerFactory.create(userId));
        if(seller == null)throw new UserNotFound(userId);
        return new FollowersCountResponse(seller.getId(),seller.getName(),seller.followersCount());
    }
    @Override
    public FollowersListResponse followersList(String userId) throws Exception {
        var seller = sellerRepository.find(SellerFactory.create(userId));
        if(seller == null)throw new UserNotFound(userId);

        var followersOfUser = userRepository.findAllFollowers(seller);

        var followerOfUserResponse = followersOfUser.stream().map(UserResponse::new).collect(Collectors.toList());

        return new FollowersListResponse(seller.getId(),seller.getName(),followerOfUserResponse);
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

