package com.calypso.finance.stock_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calypso.finance.stock_app.model.UserPersistence;
import com.calypso.finance.stock_app.repository.UserRepository;

@Service
public class LoginService {
	@Autowired
	private UserRepository userRepository;
	
	public List<UserPersistence> validateUser(String name, String pass){
		return userRepository.findByUsernameAndPassword(name, pass);
	}

}
