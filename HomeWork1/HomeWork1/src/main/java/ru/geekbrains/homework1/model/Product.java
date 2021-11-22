package ru.geekbrains.homework1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Product {

    private int id;
    private String title;
    private int cost;
    private List<Product> products;

}
