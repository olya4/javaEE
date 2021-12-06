package ru.gb.dao;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Product;


@Repository
@RequiredArgsConstructor
public class ProductDaoImpl implements ProductDao {

    private final SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Product> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Product p").list();
    }
}
