package com.calypso.finance.stock_app.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.calypso.finance.stock_app.model.PersonPersistence;

@Repository
public interface PersonRepository extends CrudRepository<PersonPersistence,Integer> {
	

}
