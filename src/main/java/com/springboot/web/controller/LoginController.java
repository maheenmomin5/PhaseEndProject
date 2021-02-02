package com.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.web.model.employeesEntity;
import com.springboot.web.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model){
		return "login";
	}
	@RequestMapping(value="/login", method = RequestMethod.POST)
    public String processLogin(ModelMap model, @ModelAttribute("employees") employeesEntity user) {
       
		boolean blank = false;

		if (!(service.checkUserNameExists(user.getUsername()))) {
			model.put("usernameERROR", "Username does not exist");
			blank = true;
		}
		if (service.checkForBlanks(user.getUsername())) {
			model.put("usernameERROR", "Username can not be blank, empty, or contain empty spaces");
			blank = true;
		}
		if (service.checkForBlanks(user.getPassword())) {
			model.put("passwordERROR", "Password can not be blank, empty, or contain empty spaces");
			blank = true;
		}
	
		


		if (blank) {
			return "login";
		} else {
			model.clear();
		}

		if (service.validateUser(user.getUsername(), user.getPassword())) {
			// if user and password is correct
			model.put("name", user.getUsername());
			model.put("message", "You have been Logged In Successfully");
			return "welcome";
		}

		model.put("error", "Incorrect password");
		return "login";
	}
	
	@RequestMapping(value="/retButton",params="welcomeBtn",method=RequestMethod.POST)
	public String logToWelcomeAction(ModelMap model) { return "redirect:welcome"; }

}
       
/*
 * if (service.validateUser(user.getUsername(), user.getPassword())) { // if
 * user and password is correct model.put("message", "User " +
 * user.getUsername() + " logged In Successfully"); return "todo"; }
 * 
 * model.put("invalid", "Incorrect username: " + user.getUsername() +
 * " or password: " + user.getPassword()); return "todo"; }
 * 
 * }
 */
