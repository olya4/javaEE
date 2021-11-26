package ru.geekbrains.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// обнаружение бинов
@Configuration

// будут осмотрены вес классы внутри пакета на наличие аннотаций
@ComponentScan("ru.geekbrains")

// включение спринг MVC
@EnableWebMvc
public class HelloConfiguration {

    public static final String RESOLVER_PREFIX = "/WEB-INF/view/";
    public static final String RESOLVER_SUFFIX = ".jsp";

    @Bean
    public ViewResolver viewResolver() {
        // реализация интерфейса ViewResolver
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        // путь к файлу message.jsp
        viewResolver.setPrefix(RESOLVER_PREFIX);
        viewResolver.setSuffix(RESOLVER_SUFFIX);
        return viewResolver;
    }

}
