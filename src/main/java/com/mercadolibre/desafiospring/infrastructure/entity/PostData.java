package com.mercadolibre.desafiospring.infrastructure.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class PostData {
    private UUID id;
    private UUID userId;
    private LocalDateTime postedAt;
    private ProductData product;
    private Integer category;
    private Double price;
    private Boolean hasPromo;
    private Double discount;

    public void setHasPromo(Boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Boolean getHasPromo() {
        return hasPromo;
    }

    public PostData() {
    }

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

    public PostData(UUID id, UUID userId, LocalDateTime postedAt, ProductData product, Integer category, Double price, Boolean hasPromo, Double discount) {
        this.id = id;
        this.userId = userId;
        this.postedAt = postedAt;
        this.product = product;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public Double getDiscount() {
        return discount;
    }
}
