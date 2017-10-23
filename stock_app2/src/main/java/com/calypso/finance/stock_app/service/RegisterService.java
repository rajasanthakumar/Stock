package com.calypso.finance.stock_app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calypso.finance.stock_app.model.PersonPersistence;
import com.calypso.finance.stock_app.repository.PersonRepository;

@Service
public class RegisterService {
	@Autowired
	private PersonRepository personRepository;
	
	public PersonPersistence createPerson(PersonPersistence personPersistence) {

		return personRepository.save(personPersistence);
	}

}
