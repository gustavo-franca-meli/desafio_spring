package com.mercadolibre.desafiospring.aplication.requests;

public class CreatePromoPostRequest extends CreatePostRequest {
    public Double discount;

    public CreatePromoPostRequest(Double discount) {
        this.discount = discount;
    }

    public CreatePromoPostRequest(String userId, String idPost, ProductRequest detail, Integer category, Double price, Double discount) {
        super(userId, idPost, detail, category, price);
        this.discount = discount;
    }
}
