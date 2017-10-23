package com.calypso.finance.stock_app.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.calypso.finance.stock_app.model.PersonPersistence;
import com.calypso.finance.stock_app.model.UserPersistence;
import com.calypso.finance.stock_app.service.RegisterService;

@RestController
@RequestMapping("/app")
public class RegistrationController {

	@Autowired
	private RegisterService registerService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("registration");
		return mav;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public RedirectView createPerson(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password, @RequestParam(value = "name") String name,
			@RequestParam(value = "city") String city, @RequestParam(value = "age") int age) {

		PersonPersistence personObj = new PersonPersistence();
		personObj.setAge(age);
		personObj.setCity(city);
		personObj.setName(name);
		UserPersistence user = new UserPersistence();
		user.setPassword(password);
		user.setUsername(username);
		user.setPersonPersistence(personObj);
		
		RedirectView rv = new RedirectView();

		Set<UserPersistence> userPersistences = new HashSet<>();
		userPersistences.add(user);

		personObj.setUserPersistence(userPersistences);
		
		if (null != registerService.createPerson(personObj))
			rv.setUrl("login");
		else
			rv.setUrl("register");
		return rv;

	}

}
