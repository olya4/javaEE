package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.dao.RosterDao;
import ru.gb.entity.Roster;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RosterService {

    private final RosterDao rosterDao;

    // вывести все заказы покупателя
    public List<Roster> findAll(Long id) {
        return rosterDao.findAllByBuyer_Id(id);
    }

    public List<Roster> findAllSortedByAsc(Long id) {
        return rosterDao.findAllByBuyer_Id(id, Sort.by("cost"));

    }

    public List<Roster> findAllSortedByDesc(Long id) {
        return rosterDao.findAllByBuyer_Id(id, Sort.by(Sort.Direction.DESC, "cost"));
    }

}

