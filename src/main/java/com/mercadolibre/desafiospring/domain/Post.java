package com.mercadolibre.desafiospring.domain;

import com.mercadolibre.desafiospring.aplication.requests.ProductRequest;

import java.time.LocalDate;
import java.util.UUID;

public class Post {
    private UUID id;
    private User user;
    private LocalDate date;
    private Product product;
    private Integer category;
    private Double price;

    public Post( UUID idPost,User user, LocalDate date, Product product, Integer category, Double price) {
        this.user = user;
        this.id = idPost;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }

    public UUID getUserId() {
        return user.getId();
    }

    public LocalDate getDate() {
        return date;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public UUID getId() {
        return id;
    }
}
