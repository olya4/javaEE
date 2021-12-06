package ru.gb.dao;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Buyer;

@Repository
@RequiredArgsConstructor
public class BuyerDaoImpl implements BuyerDao {

    private final SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Buyer> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Buyer m").list();
    }

    @Override
    @Transactional(readOnly = true)
    public Buyer findById(Long id) {
        return (Buyer) sessionFactory.getCurrentSession().getNamedQuery("Buyer.findById").setParameter("id", id).uniqueResult();
    }

    @Override
    @Transactional(readOnly = true)
    public String findNameById(Long id) {
        return (String) sessionFactory.getCurrentSession().getNamedQuery("Buyer.findNameById").setParameter("id", id).uniqueResult();
    }

    @Override
    @Transactional
    public Buyer save(Buyer buyer) {
        sessionFactory.getCurrentSession().saveOrUpdate(buyer);
        return buyer;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        final Buyer buyer = new Buyer();
        buyer.setId(id);
        sessionFactory.getCurrentSession().remove(buyer);
    }
}
