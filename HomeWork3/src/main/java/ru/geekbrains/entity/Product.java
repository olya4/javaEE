package ru.geekbrains.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer id;
    private String title;
    private Integer cost;
}
