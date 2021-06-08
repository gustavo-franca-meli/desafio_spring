package com.mercadolibre.desafiospring.domain.exception;

public class SellerNotFoundException extends EntityNotFoundException {
    public SellerNotFoundException(String sellerId) {
        super(String.format("Seller %s not found",sellerId));
    }
}
