package org.example.arbeidskravbackend.Bicycle;

import jakarta.persistence.*;

@Entity
public class Bicycle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bicycle_seq")
    @SequenceGenerator(name = "bicycle_seq", sequenceName = "bicycle_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String color;
    private String model;
    private Long inStock;
    private String manufacturer;

    public Bicycle(String name, String color, String model, Long inStock, String manufacturer) {
        this.name = name;
        this.color = color;
        this.model = model;
        this.inStock = inStock;
        this.manufacturer = manufacturer;
    }

    public Bicycle() {
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getInStock() {
        return inStock;
    }

    public void setInStock(Long inStock) {
        this.inStock = inStock;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
