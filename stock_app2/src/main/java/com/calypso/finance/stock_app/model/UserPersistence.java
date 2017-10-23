package com.calypso.finance.stock_app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "USER")
public class UserPersistence {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USERID")
	private int id;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@ManyToOne
	@JoinColumn(name="PERSONID")
	@JsonIgnore
	private PersonPersistence personPersistence;

	public int getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public PersonPersistence getPersonPersistence() {
		return personPersistence;
	}

	public String getUsername() {
		return username;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPersonPersistence(PersonPersistence personPersistence) {
		this.personPersistence = personPersistence;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}

