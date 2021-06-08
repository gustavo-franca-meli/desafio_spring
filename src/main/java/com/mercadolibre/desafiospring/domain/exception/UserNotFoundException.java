package com.mercadolibre.desafiospring.domain.exception;

import com.mercadolibre.desafiospring.domain.User;

public class UserNotFoundException extends EntityNotFoundException {
    public UserNotFoundException(String userId) {
        super(String.format("User %s not found",userId));
    }
}
