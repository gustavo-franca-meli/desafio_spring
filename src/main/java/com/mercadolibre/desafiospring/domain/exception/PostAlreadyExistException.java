package com.mercadolibre.desafiospring.domain.exception;

import com.mercadolibre.desafiospring.domain.exception.ConflictException;

public class PostAlreadyExistException extends ConflictException {
    public PostAlreadyExistException(String postId) {
        super(String.format("Post %s Already exist, please try other id",postId));
    }
}
