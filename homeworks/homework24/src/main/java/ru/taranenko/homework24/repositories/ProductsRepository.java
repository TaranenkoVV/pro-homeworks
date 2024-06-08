package ru.taranenko.homework24.repositories;

import ru.taranenko.homework24.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository {
    List<Product> findAll();
    Product createNew(Product product);
    Optional<Product> findById(String id);
    Optional<Product> deleteById(String id);
}
