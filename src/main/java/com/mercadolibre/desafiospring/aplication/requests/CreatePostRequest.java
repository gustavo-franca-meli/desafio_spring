package com.mercadolibre.desafiospring.aplication.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.boot.jackson.JsonComponent;

import java.time.LocalDate;
import java.util.UUID;

public class CreatePostRequest {
    public  String userId;
    public  String idPost;
    public LocalDate date;
    public ProductRequest detail;
    public Integer category;
    public Double price;


    public CreatePostRequest() {
    }

    public CreatePostRequest(String userId, String idPost, LocalDate date, ProductRequest detail, Integer category, Double price) {
        this.userId = userId;
        this.idPost = idPost;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }
}
