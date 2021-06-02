package com.mercadolibre.desafiospring.infrastructure.entity;

import com.mercadolibre.desafiospring.domain.Product;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class PostData {
    private UUID id;
    private UUID userId;
    private LocalDateTime postedAt;
    private ProductData product;
    private Integer category;
    private Double price;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public LocalDateTime getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(LocalDateTime postedAt) {
        this.postedAt = postedAt;
    }

    public ProductData getProduct() {
        return product;
    }

    public void setProduct(ProductData product) {
        this.product = product;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public PostData(UUID id, UUID userId, LocalDateTime postedAt, ProductData product, Integer category, Double price) {
        this.id = id;
        this.userId = userId;
        this.postedAt = postedAt;
        this.product = product;
        this.category = category;
        this.price = price;
    }
}
