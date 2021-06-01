package com.mercadolibre.desafiospring.aplication.requests;

import java.time.LocalDate;
import java.util.UUID;

public class CreatePostRequest {
    public  UUID userId;
    public  UUID idPost;
    public LocalDate date;
    public ProductRequest detail;
    public Integer category;
    public Double price;

    public CreatePostRequest() {
    }

    public CreatePostRequest(UUID userId, UUID idPost, LocalDate date, ProductRequest detail, Integer category, Double price) {
        this.userId = userId;
        this.idPost = idPost;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }
}
