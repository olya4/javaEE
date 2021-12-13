package ru.gb.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.gb.entity.Product;

public interface ProductDao extends PagingAndSortingRepository<Product, Long> {

}
