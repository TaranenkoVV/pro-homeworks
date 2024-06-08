package ru.taranenko.homework24.entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Product {
    private String id;
    private String title;
    private Double price;

    public Product(String title, Double price) {
        this.title = title;
        this.price = price;
    }
}
