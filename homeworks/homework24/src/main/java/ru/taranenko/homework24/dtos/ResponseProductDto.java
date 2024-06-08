package ru.taranenko.homework24.dtos;

import java.util.*;
import lombok.*;
import ru.taranenko.homework24.entities.Product;

@NoArgsConstructor
@Getter
@Setter
public class ResponseProductDto {
  private List<Product> products;
}
