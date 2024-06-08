package ru.taranenko.homework24.dtos;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class CreateProductDto {
    private String title;
    private Double price;
}
