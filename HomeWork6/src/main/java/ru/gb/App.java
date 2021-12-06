package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.config.HibernateConfig;
import ru.gb.dao.BuyerDao;
import ru.gb.dao.ProductDao;
import ru.gb.dao.RosterDao;
import ru.gb.entity.Buyer;
import ru.gb.entity.Product;
import ru.gb.entity.Roster;

import java.util.HashSet;
import java.util.List;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        BuyerDao buyerDao = context.getBean(BuyerDao.class);
        RosterDao rosterDao = context.getBean(RosterDao.class);
        ProductDao productDao = context.getBean(ProductDao.class);

        System.out.println(buyerDao.findById(1L));

//        Roster testRoster = Roster.builder()
//                .buyer(buyerDao.findById(1L))
//                .products(new HashSet<>(((List<Product>) productDao.findAll()).subList(1, 5)))
//                .build();
//        rosterDao.save(testRoster);

    }
}
