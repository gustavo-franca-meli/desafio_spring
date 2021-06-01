package com.mercadolibre.desafiospring.domain;

import java.util.UUID;

public class Product {
    private UUID id;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
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

    public Product(UUID id, String name, String type, String brand, String color, String notes) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }

}
