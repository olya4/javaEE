package ru.geekbrains.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Slf4j
// класс бев-инициализатор
public class WebConfig implements WebApplicationInitializer {

    // имя сервлета
    public static final String DISPATCHER_SERVLET_NAME = "dispatcher";

    // автоматически вызывается при запуске приложения (при старте TomCat)
    // servletContext - context TomCat
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.info("In method onStartup");

        // создание context спринга
        // context теперь будет вызываться не из main, а из onStartup
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        // регистрация класса конфигурации
        context.register(HelloConfiguration.class);

        // создание сервлета
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        // сообщение TomCat, что сервлет создан
        // addServlet (имя сервлета, сам сервлет)
        // первый параметр - имя сервлета, который надо зарегистрировать
        // второй параметр - сам сервлет
        ServletRegistration.Dynamic registration = servletContext.addServlet(DISPATCHER_SERVLET_NAME, dispatcherServlet);

        // перенаправление трафика на сервлет
        // 1 - чтобы сервлет загружался в самом начале
        registration.setLoadOnStartup(1);
        // какие url будет перехватывать dispatcherServlet
        // "/" - dispatcherServlet будет ловить весь трафик TomCat
        registration.addMapping("/");

    }
}
