package org.example.arbeidskravbackend.Bicycle;

public record BicycleDto(
        String name,
        String color,
        String model,
        Long inStock,
        Long manufacturerId
){}
