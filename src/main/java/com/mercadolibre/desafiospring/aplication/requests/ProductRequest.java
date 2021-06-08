package com.mercadolibre.desafiospring.aplication.requests;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class ProductRequest {
    @NotEmpty
    public String productId;
    @NotEmpty
    public String productName;
    @NotEmpty
    public String type;
    @NotNull
    public String brand;
    @NotEmpty
    public String color;
    @NotEmpty
    public String notes;

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getNotes() {
        return notes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ProductRequest() {
    }

 /*   public ProductRequest(String productId, String productName, String type, String brand, String color, String notes) {
        this.productId = productId;
        this.productName = productName;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }*/
}
