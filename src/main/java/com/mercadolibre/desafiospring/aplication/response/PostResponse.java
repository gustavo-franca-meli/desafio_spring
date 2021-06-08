package com.mercadolibre.desafiospring.aplication.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mercadolibre.desafiospring.aplication.requests.ProductRequest;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.UUID;

public class PostResponse {
    public UUID userId;
    public UUID idPost;
    public ProductResponse detail;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy hh:mm:ss")
    public LocalDateTime postedAt;
    public Integer category;
    public Double price;

    public PostResponse() {
    }

    public PostResponse(UUID userId, UUID idPost, ProductResponse detail, LocalDateTime postedAt, Integer category, Double price) {
        this.userId = userId;
        this.idPost = idPost;
        this.detail = detail;
        this.postedAt = postedAt;
        this.category = category;
        this.price = price;
    }
}

