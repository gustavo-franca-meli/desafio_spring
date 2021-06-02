package com.mercadolibre.desafiospring.aplication.requests;

import java.time.LocalDate;
import java.util.UUID;

public class CreatePostRequest {
    public  String userId;
    public  String idPost;
    public ProductRequest detail;
    public Integer category;
    public Double price;

    public CreatePostRequest() {
    }

    public CreatePostRequest(String userId, String idPost, ProductRequest detail, Integer category, Double price) {
        this.userId = userId;
        this.idPost = idPost;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }
}
