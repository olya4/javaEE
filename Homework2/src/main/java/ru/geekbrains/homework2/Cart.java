package ru.geekbrains.homework2;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// класс Cart является бином
@Component

@Scope("singleton")
public class Cart {

    private final ProductRepository productRepository;

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // добавить продукт в список
    public void addProduct(int id, String title, int cost) {
        getProductRepository().products.add(new Product(id, title, cost));
    }

    // удалить продукт по id
    public void deleteProduct(int id) {
        getProductRepository().products.remove(id - 1);
    }

    // чтоб каждый раз вызывался новый список
    @Lookup
    public ProductRepository getProductRepository() {
        return null;
    }
}
