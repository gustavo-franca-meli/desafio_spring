package com.mercadolibre.desafiospring.aplication.requests;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class CreatePostRequest {
    @NotEmpty()
    public  String userId;
    @NotEmpty()
    public  String idPost;
    @NotNull
    @Valid
    public ProductRequest detail;
    @NotNull()
    public Integer category;
    @NotNull()
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
