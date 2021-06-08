package com.mercadolibre.desafiospring.aplication.useCase;

import com.mercadolibre.desafiospring.aplication.requests.OrderQuery;
import com.mercadolibre.desafiospring.domain.exception.RepositoryNotAvailable;
import com.mercadolibre.desafiospring.domain.exception.SellerNotFoundException;
import com.mercadolibre.desafiospring.domain.exception.UserIsAlreadyUnfollowingException;
import com.mercadolibre.desafiospring.aplication.response.FollowersCountResponse;
import com.mercadolibre.desafiospring.aplication.response.FollowersListResponse;
import com.mercadolibre.desafiospring.aplication.response.FollowingListResponse;
import com.mercadolibre.desafiospring.domain.exception.UserNotFoundException;

public interface UserUseCase {
    void follow(String userId, String UserIdToFollow) throws Exception;

    FollowersCountResponse followersCount(String userId) throws UserNotFoundException, SellerNotFoundException;

    FollowersListResponse followersList(String userId) throws Exception;

    FollowingListResponse followingList(String userId) throws Exception;

    void unfollow(String userId, String userIdToUnfollow) throws UserNotFoundException, UserIsAlreadyUnfollowingException, IllegalArgumentException, RepositoryNotAvailable, SellerNotFoundException;

    FollowersListResponse followersList(String userId, OrderQuery orderQuery) throws Exception;

    FollowingListResponse followingList(String userId, OrderQuery orderQuery) throws Exception;
}
