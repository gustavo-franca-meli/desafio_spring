package com.mercadolibre.desafiospring.aplication.response;

import java.util.UUID;

public class ProductResponse {
    public UUID productId;
    public String productName;
    public String type;
    public String brand;
    public String color;
    public String notes;

    public ProductResponse() {
    }

    public ProductResponse(UUID productId, String productName, String type, String brand, String color, String notes) {
        this.productId = productId;
        this.productName = productName;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }
}
