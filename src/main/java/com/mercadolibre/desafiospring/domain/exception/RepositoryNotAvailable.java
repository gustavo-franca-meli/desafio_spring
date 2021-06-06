package com.mercadolibre.desafiospring.domain.exception;

public class RepositoryNotAvailable extends Exception {
    public RepositoryNotAvailable(String database_unavailable) {
        super(database_unavailable);
    }
}
