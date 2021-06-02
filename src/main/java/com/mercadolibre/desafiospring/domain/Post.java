package com.mercadolibre.desafiospring.domain;

import com.mercadolibre.desafiospring.aplication.requests.ProductRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Post {
    private UUID id;
    private User user;
    private LocalDateTime postedAt;
    private Product product;
    private Integer category;
    private Double price;

    public Post(UUID id, User user, LocalDateTime postedAt, Product product, Integer category, Double price) {
        this.id = id;
        this.user = user;
        this.postedAt = postedAt;
        this.product = product;
        this.category = category;
        this.price = price;
    }

    public Post(UUID idPost, User user, Product product, Integer category, Double price) {
        this(idPost,user,LocalDateTime.now(),product,category,price);
    }

    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getPostedAt() {
        return postedAt;
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

    public UUID getUserId() {
        return this.user.getId();
    }
}
