package ru.geekbrains.homework2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Basket.class);

        Cart cart = context.getBean(Cart.class);

        // вывести список продуктов
        cart.getProductRepository().getProducts();
        System.out.println();

        // получить продукт по id
        cart.getProductRepository().getProductById(2);
        System.out.println();

        // добавить продукт в список
        cart.addProduct(6, "Tea", 200);

        // удалить продукт по id
        cart.deleteProduct(2);

    }
}
