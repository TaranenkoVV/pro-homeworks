package ru.taranenko.homework24.services;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import ru.taranenko.homework24.dtos.CreateProductDto;
import ru.taranenko.homework24.dtos.ResponseProductDto;
import ru.taranenko.homework24.entities.Product;
import ru.taranenko.homework24.repositories.ProductsRepository;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private static final Logger logger = LoggerFactory.getLogger(ProductsService.class.getName());

    private final ProductsRepository productsRepository;

    public ResponseProductDto getAllProducts() {
        List<Product> productsList = productsRepository.findAll();
        ResponseProductDto responseProductDto = new ResponseProductDto();
        responseProductDto.setProducts(productsList);
        return responseProductDto;
    }

    public Product createNewProduct(CreateProductDto createProductDto) {

        if (createProductDto.getPrice() == null) {
            throw new RuntimeException("Цена продукта не может быть равна null");
        }

        Product product = Product.builder()
                .title(createProductDto.getTitle())
                .price(createProductDto.getPrice())
                .build();

        product = productsRepository.createNew(product);
        logger.info("Product id = {} created from {}", product.getId(), createProductDto);
        return product;
    }

    public Product getProductById(String id) {

        return productsRepository.findById(id).get();
    }

    public Product deleteProductById(String id) {

        return productsRepository.deleteById(id).get();
    }
    
}
