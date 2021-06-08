package com.mercadolibre.desafiospring.domain.exception;

public class ConflictException extends Exception {
    public ConflictException(String message) {
        super(message);
    }
}
