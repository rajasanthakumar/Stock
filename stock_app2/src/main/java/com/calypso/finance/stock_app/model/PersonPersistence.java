package com.calypso.finance.stock_app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
public class PersonPersistence {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PERSONID")
	private int personid;

	@Column(name = "FULLNAME")
	private String name;

	@Column(name = "AGE")
	private int age;

	@Column(name = "USERCITY")
	private String city;

	@OneToMany(mappedBy = "personPersistence", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<UserPersistence> userPersistence = new HashSet<>();

	public int getAge() {
		return age;
	}

	public String getCity() {
		return city;
	}

	public String getName() {
		return name;
	}

	public int getPersonid() {
		return personid;
	}

	public Set<UserPersistence> getUserPersistence() {
		return userPersistence;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPersonid(int personid) {
		this.personid = personid;
	}

	public void setUserPersistence(Set<UserPersistence> userPersistence) {
		this.userPersistence = userPersistence;
	}

}
