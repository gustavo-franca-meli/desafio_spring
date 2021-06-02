package com.mercadolibre.desafiospring.aplication.response;

import com.mercadolibre.desafiospring.aplication.requests.ProductRequest;

import java.util.UUID;

public class PostResponse {
    public UUID userId;
    public UUID idPost;
    public ProductResponse detail;
    public Integer category;
    public Double price;

    public PostResponse() {
    }

    public PostResponse(UUID idPost,UUID userId, ProductResponse detail, Integer category, Double price) {
        this.userId = userId;
        this.idPost = idPost;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

}

