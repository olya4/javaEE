package ru.geekbrains.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.geekbrains.entity.Product;
import ru.geekbrains.service.ProductService;

// @Controller - класс ProductController является бином
@Controller

// @RequestMapping - взаимодействие с браузером
@RequestMapping("/product")

@RequiredArgsConstructor
public class ProductController {

    // зависимость
    private final ProductService productService;

    // метод создания формы
    // RequestMethod.GET - для получения формы из файла create-product.jsp
    // и отображения ее в браузере
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showSimpleForm(Model model) {
        // пустой объект Product
        Product product = new Product();
        // передача product в файл product.jsp
        // в файле product.jsp на место "product" будет выведено product
        model.addAttribute("product", product);
        // вызвать файл product.jsp
        return "create-product";
    }

    // метод обработки формы и сохранения в репозиторий
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String processForm(Product product) {
        if (product.getId() == null) {
            // сохранить новый продукт
            productService.save(product);
        }
        // вернуть список всех продуктов
        return "redirect:/product/all";
    }

    // метод вывода списка продуктов в браузер
    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public String getAllProduct(Model model) {
        model.addAttribute("products", productService.getAll());
        // вызвать файл product-list.jsp
        return "product-list";
    }

    // метод вывода продукта по id
    // "/{id}" - (@PathVariable) эта часть url будет считана, как аргумент метода
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String getProductById(Model model, @PathVariable Integer id) {
        Product product = null;
        product = productService.findById(id);
        model.addAttribute("product", product);
        // вызвать файл product.jsp
        return "product";
    }

}
