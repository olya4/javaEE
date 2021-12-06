package ru.gb.dao;


import ru.gb.entity.Roster;

public interface RosterDao {

    Iterable<Roster> findAll();

    Roster findById(Long id);

    Roster save(Roster roster);

    void deleteById(Long id);
}

