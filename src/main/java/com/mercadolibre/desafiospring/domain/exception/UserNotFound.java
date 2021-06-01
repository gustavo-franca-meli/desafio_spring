package com.mercadolibre.desafiospring.domain.exception;

import com.mercadolibre.desafiospring.domain.User;

public class UserNotFound extends Exception {
    public UserNotFound(String userId) {
        super(String.format("User %s not found",userId));
    }
}
