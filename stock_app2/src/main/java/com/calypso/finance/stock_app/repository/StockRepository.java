package com.calypso.finance.stock_app.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.calypso.finance.stock_app.model.StockPersistence;

@Repository
public interface StockRepository extends CrudRepository<StockPersistence,Integer> {

}
