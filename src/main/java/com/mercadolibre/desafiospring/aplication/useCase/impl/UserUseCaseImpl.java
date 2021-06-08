package com.mercadolibre.desafiospring.aplication.useCase.impl;

import com.mercadolibre.desafiospring.aplication.requests.OrderQuery;
import com.mercadolibre.desafiospring.aplication.response.UserResponse;
import com.mercadolibre.desafiospring.aplication.response.FollowersCountResponse;
import com.mercadolibre.desafiospring.aplication.response.FollowersListResponse;
import com.mercadolibre.desafiospring.aplication.response.FollowingListResponse;
import com.mercadolibre.desafiospring.domain.exception.*;
import com.mercadolibre.desafiospring.aplication.useCase.UserUseCase;
import com.mercadolibre.desafiospring.domain.factories.SellerFactory;
import com.mercadolibre.desafiospring.domain.factories.UserFactory;
import com.mercadolibre.desafiospring.infrastructure.SellerRepository;
import com.mercadolibre.desafiospring.infrastructure.UserRepository;
import org.springframework.stereotype.Service;

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
        if(sellerToFollow == null)throw  new EntityNotFoundException("following seller does not exist");


        if(!user.follow(sellerToFollow))throw new UserIsAlreadyFollowingException(user, sellerToFollow);
        userRepository.save(user);
        sellerRepository.save(sellerToFollow);
    }

    @Override
    public FollowersCountResponse followersCount(String sellerId) throws SellerNotFoundException {
        var seller = sellerRepository.find(SellerFactory.create(sellerId));
        if(seller == null)throw new SellerNotFoundException(sellerId);
        return new FollowersCountResponse(seller.getId(),seller.getName(),seller.followersCount());
    }
    @Override
    public FollowersListResponse followersList(String sellerId) throws Exception {
        var seller = sellerRepository.find(SellerFactory.create(sellerId));
        if(seller == null)throw new SellerNotFoundException(sellerId);

        var followersOfUser = userRepository.findAllFollowers(seller);

        var followerOfUserResponse = followersOfUser.stream().map(UserResponse::new).collect(Collectors.toList());

        return new FollowersListResponse(seller.getId(),seller.getName(),followerOfUserResponse);
    }

    @Override
    public FollowersListResponse followersList(String sellerId, OrderQuery orderQuery) throws Exception {
        var seller = sellerRepository.find(SellerFactory.create(sellerId));
        if(seller == null)throw new SellerNotFoundException(sellerId);

        var followersOfUser = userRepository.findAllFollowers(seller,orderQuery);

        var followerOfUserResponse = followersOfUser.stream().map(UserResponse::new).collect(Collectors.toList());

        return new FollowersListResponse(seller.getId(),seller.getName(),followerOfUserResponse);
    }

    @Override
    public FollowingListResponse followingList(String userId, OrderQuery orderQuery) throws Exception {
        var user = userRepository.find(UserFactory.create(userId));
        if(user == null)throw new UserNotFoundException(userId);

        var followersOfUser = userRepository.findAllFollowing(user,orderQuery);

        var followerOfUserResponse = followersOfUser.stream().map(UserResponse::new).collect(Collectors.toList());

        return new FollowingListResponse(user.getId(),user.getName(),followerOfUserResponse);
    }

    @Override
    public FollowingListResponse followingList(String userId) throws Exception {
        var user = userRepository.find(UserFactory.create(userId));
        if(user == null)throw new UserNotFoundException(userId);

        var followersOfUser = userRepository.findAllFollowing(user);

        var followerOfUserResponse = followersOfUser.stream().map(UserResponse::new).collect(Collectors.toList());

        return new FollowingListResponse(user.getId(),user.getName(),followerOfUserResponse);
    }

    @Override
    public void unfollow(String userId, String sellerIdToUnfollow) throws UserNotFoundException, UserIsAlreadyUnfollowingException, IllegalArgumentException, RepositoryNotAvailable, SellerNotFoundException {
        var user = userRepository.find(UserFactory.create(userId));
        var sellerToUnfollow = sellerRepository.find(SellerFactory.create(sellerIdToUnfollow));

        if(user == null)throw new UserNotFoundException(userId);
        if(sellerToUnfollow == null)throw  new SellerNotFoundException(sellerIdToUnfollow);


        if(!user.unfollow(sellerToUnfollow))throw new UserIsAlreadyUnfollowingException(user, sellerToUnfollow);
        userRepository.save(user);
        sellerRepository.save(sellerToUnfollow);
    }


}

