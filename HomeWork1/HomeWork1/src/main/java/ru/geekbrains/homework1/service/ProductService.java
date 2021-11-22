package ru.geekbrains.homework1.service;

import ru.geekbrains.homework1.model.Product;

import java.util.Arrays;
import java.util.List;

public class ProductService {

    public Product createProduct() {
        List<Product> products = Arrays.asList(
                new Product(1, "Apple", 100, null),
                new Product(2, "Bread", 50, null),
                new Product(3, "Milk", 230, null),
                new Product(4, "Cookies", 300, null),
                new Product(5, "Chocolate", 410, null),
                new Product(6, "Orange", 200, null),
                new Product(7, "Banana", 150, null),
                new Product(8, "Sugar", 190, null),
                new Product(9, "Peach", 245, null),
                new Product(10, "Tea", 85, null)
        );
        return new Product(0, "Water", 50, products);
    }
}
