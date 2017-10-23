package com.calypso.finance.stock_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.calypso.finance.stock_app.model.UserPersistence;
import com.calypso.finance.stock_app.service.LoginService;

@RestController
@RequestMapping("/app")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/login" , method = RequestMethod.GET)
	public ModelAndView index() {
		    ModelAndView mav = new ModelAndView();
		    mav.setViewName("login");
		    return mav;
    }
	@RequestMapping(value="/login" , method = RequestMethod.POST)
	public RedirectView loginValidation(@RequestParam(value = "username") String username,@RequestParam(value = "password") String password) {
		    
		List<UserPersistence> users=loginService.validateUser(username, password);
		RedirectView rv = new RedirectView();
		if(users.isEmpty())
		{	
			rv.setUrl("register");
		}
		else
		{
			rv.setUrl("stock");
		}
		return rv;
    }

}
