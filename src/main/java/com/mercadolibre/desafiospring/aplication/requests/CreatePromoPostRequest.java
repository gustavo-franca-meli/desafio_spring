package com.mercadolibre.desafiospring.aplication.requests;

import javax.validation.constraints.NotNull;

public class CreatePromoPostRequest extends CreatePostRequest {
    @NotNull
    public Double discount;

    public CreatePromoPostRequest(Double discount) {
        this.discount = discount;
    }

    public CreatePromoPostRequest(String userId, String idPost, ProductRequest detail, Integer category, Double price, Double discount) {
        super(userId, idPost, detail, category, price);
        this.discount = discount;
    }
}
