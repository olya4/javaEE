package ru.gb.dao;

import ru.gb.entity.Product;

public interface ProductDao {

    Iterable<Product> findAll();

    Product findById(Long id);

    String findTitleById(Long id);

    void insert(Product product);

    void update(Product product);

    void deleteById(Long id);
}
