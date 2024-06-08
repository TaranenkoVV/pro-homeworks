package ru.taranenko.homework24.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.taranenko.homework24.dtos.ResponseProductDto;
import ru.taranenko.homework24.entities.Product;
import ru.taranenko.homework24.services.ProductsService;
import ru.taranenko.homework24.dtos.CreateProductDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductsController {
    private final ProductsService productsService;

    @GetMapping
    public ResponseProductDto getAllProducts() {
        return productsService.getAllProducts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createNewProduct(@RequestBody CreateProductDto createProductDto) {
        return productsService.createNewProduct(createProductDto);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        return productsService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public Product deleteProductById(@PathVariable String id) {
        return productsService.deleteProductById(id);
    }

}
