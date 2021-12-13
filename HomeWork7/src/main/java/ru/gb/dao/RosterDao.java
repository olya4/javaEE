package ru.gb.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.gb.entity.Roster;

import java.util.List;

public interface RosterDao extends PagingAndSortingRepository<Roster, Long> {

    // вывести все заказы покупателя
    List<Roster> findAllByBuyer_Id(Long id);

    List<Roster> findAllByBuyer_Id(Long id, Sort sort);

}
