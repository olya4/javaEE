package ru.gb.dao;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Roster;


@Repository
@RequiredArgsConstructor
public class RosterDaoImpl implements RosterDao {

    private final SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Roster> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Roster r").list();
    }

    @Override
    @Transactional(readOnly = true)
    public Roster findById(Long id) {
        return (Roster) sessionFactory.getCurrentSession().getNamedQuery("Roster.findById").setParameter("id", id).uniqueResult();
    }

    @Override
    @Transactional
    public Roster save(Roster roster) {
        sessionFactory.getCurrentSession().saveOrUpdate(roster);
        return roster;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        final Roster roster = new Roster();
        roster.setId(id);
        sessionFactory.getCurrentSession().remove(roster);
    }
}
