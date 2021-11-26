package ru.geekbrains.repository;

import org.springframework.stereotype.Component;
import ru.geekbrains.entity.Product;

import java.util.ArrayList;
import java.util.List;

// класс ProductRepository является бином
@Component
public class ProductRepository {

    // список продуктов
    List<Product> products = new ArrayList<>();

    // сохранить новый продукт
    public Product saveProduct(Product product) {
        // добавить продукт в список
        products.add(product);
        // присвоить продукту id
        product.setId(products.size() - 1);
        // создать продукт
        return Product.builder()
                .id(product.getId())
                .title(product.getTitle())
                .cost(product.getCost())
                .build();
    }

    // выдать список всех продуктов
    public Iterable<Product> getAll() {
        // вернуть копию списка
        return new ArrayList<>(products);
    }

    // найти продукт по id
    public Product findById(int id) {
        // если id  внутри списка
        if (id < products.size()) {
            return products.get(id);
        } else {
            // если id некорректный
            return null;
        }
    }

}
