package ru.geekbrains.homework4.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import ru.geekbrains.homework4.entity.Product;

import java.util.List;

@Configuration ("/product")
@ConfigurationProperties("all")
@Getter
@Setter
public class ProductProps {

    private Integer id;
    private String title;
    private double cost;

    private List<Product> products;

}
