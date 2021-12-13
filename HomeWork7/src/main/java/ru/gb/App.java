package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.config.JpaConfig;
import ru.gb.service.RosterService;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
        RosterService rosterService = context.getBean(RosterService.class);

       System.out.println(rosterService.findAllSortedByAsc(1L));

    }
}
