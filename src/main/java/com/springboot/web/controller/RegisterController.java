package com.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.web.model.employeesEntity;
import com.springboot.web.service.LoginService;

@Controller
public class RegisterController {
	   @Autowired
	    LoginService Service;

	 

	    @RequestMapping(value="/register", method = RequestMethod.GET)
	    public String showRegPage(ModelMap model){ 
	    	return "register"; }
	    
	    @RequestMapping(value="/register", method = RequestMethod.POST)
	    public String RegVerify(ModelMap model, @ModelAttribute employeesEntity user, @RequestParam String repassword) { 
	    	
	    	boolean blank = false;
	    	
	    	if ( Service.checkUserNameExists(user.getUsername())) { model.put("usernameERROR", "Username already exists" ); blank = true; }
			if ( Service.checkForBlanks(user.getUsername())) { model.put("usernameERROR", "Username can not be blank, empty, or contain empty spaces" ); blank = true; }
			if (Service.checkForBlanks(user.getPassword())) { model.put("passwordERROR", "Password can not be blank, empty, or contain empty spaces" ); blank = true; }
			if ( !(user.getPassword().equals(repassword))) { model.put("repasswordERROR", "Password does not match"); blank = true; }
			
			if (blank) { return "register"; } 
			else { model.clear(); }
			
			// Save if possible
			int outcome = Service.saveNewEmployees(user.getFirst_name(), user.getLast_name(), user.getUsername(), user.getPassword());

			switch (outcome) {
			case 1:
				model.put("message", "New User - <font color='green'>" + user.getUsername() + "</font> - Registered");
				return "welcome";
			case 2:
				model.put("error", "An entry is either blank or contains whitespace");
				return "register";
			default:
				model.put("error", "Unknown Error");
				return "redirect:register";

			}
			/*
			if (outcome == 1) {
				model.put("message", "New User Registered");
				return "welcome";
			}
			return "welcome";
			*/
		}
		
		@RequestMapping(value="/returnWelcomeButton",params="welcomeBtn",method=RequestMethod.POST)
		public String registerToWelcomeAction(ModelMap model) { return "redirect:welcome"; }
	    	
	    	
			/*
			 * int outcome = Service.saveNewEmployees(first_name, last_name, username,
			 * password);
			 * 
			 * switch (outcome) { case 1: model.put("message",
			 * "New User - <font color='green'>" + user.getUsername() +
			 * "</font> - Registered"); return "welcome"; case 2: model.put("error",
			 * "An entry is either blank or contains whitespace"); return "register";
			 * default: model.put("error", "Unknown Error"); return "redirect:register";
			 * 
			 * }
			 */
	//        System.out.println(outcome);
	  //      return "redirect:login";
	    }
	    
	

