package com.mercadolibre.desafiospring.domain.exception;

import com.mercadolibre.desafiospring.domain.User;

public class UserIsAlreadyFollowingException extends ConflictException {
    public UserIsAlreadyFollowingException(User userId, User userToFollow) {
        super(String.format("User %s is Already Following User %s",userId.getId().toString(),userToFollow.getId().toString()));
    }
}
