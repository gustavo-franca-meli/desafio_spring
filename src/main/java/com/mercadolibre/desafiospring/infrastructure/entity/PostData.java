package com.mercadolibre.desafiospring.infrastructure.entity;

import com.mercadolibre.desafiospring.domain.Product;

import java.time.LocalDate;
import java.util.UUID;

public class PostData {
    private UUID id;
    private UUID userId;
    private LocalDate date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public PostData() {
    }

    public PostData(UUID id, UUID userId, LocalDate date, ProductData product, Integer category, Double price) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }
}
