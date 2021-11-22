package ru.geekbrains.homework1.servlet;

import ru.geekbrains.homework1.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductHttpServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    private final ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // получить объект
        req.setAttribute("product",productService.createProduct());
        // разместить объект в браузере
        getServletContext().getRequestDispatcher("/product.jsp").forward(req, resp);
    }

}
