package com.mercadolibre.desafiospring.aplication.useCase;

import com.mercadolibre.desafiospring.aplication.requests.OrderQuery;
import com.mercadolibre.desafiospring.domain.exception.RepositoryNotAvailable;
import com.mercadolibre.desafiospring.domain.exception.UserIsAlreadyUnfollowingException;
import com.mercadolibre.desafiospring.aplication.response.FollowersCountResponse;
import com.mercadolibre.desafiospring.aplication.response.FollowersListResponse;
import com.mercadolibre.desafiospring.aplication.response.FollowingListResponse;
import com.mercadolibre.desafiospring.domain.exception.UserNotFound;

public interface UserUseCase {
    void follow(String userId, String UserIdToFollow) throws Exception;

    FollowersCountResponse followersCount(String userId) throws UserNotFound;

    FollowersListResponse followersList(String userId) throws Exception;

    FollowingListResponse followingList(String userId) throws Exception;

    void unfollow(String userId, String userIdToUnfollow) throws UserNotFound, UserIsAlreadyUnfollowingException, IllegalArgumentException, RepositoryNotAvailable;

    FollowersListResponse followersList(String userId, OrderQuery orderQuery) throws Exception;

    FollowingListResponse followingList(String userId, OrderQuery orderQuery) throws Exception;
}
