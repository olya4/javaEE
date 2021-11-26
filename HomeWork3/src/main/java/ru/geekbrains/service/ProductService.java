package ru.geekbrains.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.entity.Product;
import ru.geekbrains.repository.ProductRepository;

@Service
// для зависимости
@RequiredArgsConstructor
public class ProductService {
    // зависимость
    private final ProductRepository productRepository;

    // сохранить новый продукт
    public Product save(Product product) {
        return productRepository.saveProduct(product);
    }

    // выдать список всех продуктов
    public Iterable<Product> getAll() {
        return productRepository.getAll();
    }

    // найти продукт по id
    public Product findById(int id) {
        return productRepository.findById(id);
    }

}
