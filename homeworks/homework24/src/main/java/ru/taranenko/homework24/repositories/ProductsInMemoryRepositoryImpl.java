package ru.taranenko.homework24.repositories;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.taranenko.homework24.entities.Product;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@Component
public class ProductsInMemoryRepositoryImpl implements ProductsRepository {

    private List<Product> productsList;

    @PostConstruct
    public void init() {
        this.productsList = new ArrayList<>();
        this.productsList.add(new Product("1", "Яблоко", 20.0D));
        this.productsList.add(new Product("2", "Груша", 30.0D));
        this.productsList.add(new Product("3", "Молоко", 10.0D));
    }

    @Override
    public List<Product> findAll() {

        return productsList;
    }

    @Override
    public Product createNew(Product product) {

        String newId = String.valueOf(
                productsList.stream().mapToInt(a -> Integer.parseInt(a.getId())).max().orElse(0) + 1);
        product.setId(newId);
        productsList.add(product);
        return product;
    }

    @Override
    public Optional<Product> findById(String id) {

        Optional<Product> product = productsList.stream().filter(a -> a.getId().equals(id)).findFirst();
        return product;
    }

    @Override
    public Optional<Product> deleteById(String id) {

        Optional<Product> product = findById(id);
        if (product != null) {
            productsList.removeIf(n -> n.getId().equals(id));
        }
        return product;
    }
}
