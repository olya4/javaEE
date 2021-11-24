package ru.geekbrains.homework2;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// класс ProductRepository является бином
@Component

// @Profile("prod") - профиль бина
@Profile("prod")

@Scope("prototype")
public class ProductRepository {

    // список продуктов
    List<Product> products;

    public ProductRepository() {
        this.products = new ArrayList<>();
        products.add(new Product(1, "Apple", 100));
        products.add(new Product(2, "Banana", 150));
        products.add(new Product(3, "Chocolate", 410));
        products.add(new Product(4, "Peach", 245));
        products.add(new Product(5, "Orange", 200));
    }

    // вывести список продуктов
    public void getProducts() {
        for (Product product : products) {
            System.out.println(product.getId() + " " + product.getTitle() + " " + product.getCost());
        }
    }

    // получить продукт по id
    public void getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                System.out.println(product.getId() + " " + product.getTitle() + " " + product.getCost());
            }
        }
    }

}
