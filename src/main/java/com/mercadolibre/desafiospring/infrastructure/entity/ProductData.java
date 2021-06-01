package com.mercadolibre.desafiospring.infrastructure.entity;
import java.util.UUID;

public class ProductData {
    private UUID id;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;

    public ProductData() {
    }

    public ProductData(UUID id, String name, String type, String brand, String color, String notes) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


}
