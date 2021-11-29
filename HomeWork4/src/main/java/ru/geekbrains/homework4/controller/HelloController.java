package ru.geekbrains.homework4.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.homework4.config.ProductProps;

@Controller
@RequiredArgsConstructor
public class HelloController {

    private final ProductProps productProps;

    // метод вывода списка продуктов в браузер
    @GetMapping("/all")
    public String helloMessageJsp(Model model) {
//         коллекция не пустая и не равна null
        if (productProps != null && !CollectionUtils.isEmpty(productProps.getProducts())) {
        model.addAttribute("products", productProps.getProducts());
        } else {
            String message = "Empty list of products";
            model.addAttribute("products", message);
        }
        return "product-list";
    }

    // метод вывода продукта по id
    // "/{id}" - (@PathVariable) эта часть url будет считана, как аргумент метода
    @GetMapping(path = "/{id}")
    public String getProductById(Model model, @PathVariable Integer id) {
        model.addAttribute("product", productProps.getProducts().get(id));
        return "product";
    }

    // реакция в браузере на NullPointerException
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handNPE(NullPointerException e) {
        return "So sad, but ... fail: " + e.getMessage();
    }
}
