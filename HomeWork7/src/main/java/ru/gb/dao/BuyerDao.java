package ru.gb.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.gb.entity.Buyer;

public interface BuyerDao extends PagingAndSortingRepository<Buyer, Long> {

}
