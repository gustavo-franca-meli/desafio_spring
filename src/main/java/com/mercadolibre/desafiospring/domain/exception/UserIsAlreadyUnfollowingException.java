package com.mercadolibre.desafiospring.domain.exception;

import com.mercadolibre.desafiospring.domain.User;

public class UserIsAlreadyUnfollowingException extends Exception {
    public UserIsAlreadyUnfollowingException(User userId, User userToFollow) {
        super(String.format("User %s is Already unfollowing User %s",userId.getId().toString(),userToFollow.getId().toString()));
    }
}
