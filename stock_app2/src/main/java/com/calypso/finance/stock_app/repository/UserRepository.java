package com.calypso.finance.stock_app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.calypso.finance.stock_app.model.UserPersistence;

@Repository
public interface UserRepository extends CrudRepository<UserPersistence,Integer> {
	
	public List<UserPersistence> findByUsernameAndPassword(String username,String password);

}
