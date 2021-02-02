package com.springboot.web.service;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;

import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.annotation.SessionScope;

import com.springboot.web.model.employeesCrudRepo;
import com.springboot.web.model.employeesEntity;

@Service
@SessionScope
public class LoginService {
	
	@Autowired
	employeesCrudRepo employeeCrudRepo;

	public int saveNewEmployees(String first_name, String last_name, String username, String password) {
		String[] inputs = {first_name, last_name, username, password };
		
		
		  for (String check : inputs) { 
			  if (checkForBlanks(check)) { 
				  return 2;
				  }
			  }
		 
		try {
			employeesEntity user = new employeesEntity();
			user.setFirst_name(first_name);
			user.setLast_name(last_name);
			user.setUsername(username);
			user.setPassword(password);

			employeeCrudRepo.save(user);

			return 1;

		} catch (Exception e) {
			return 3;
		}
	
	}
	
	public boolean checkUserNameExists(String username) {
		Iterable<employeesEntity> users = employeeCrudRepo.findAll();
		
		for (employeesEntity user : users) {
			if(user.getUsername().toLowerCase().equals(username.toLowerCase())) {
				return true;
			}
		}
		return false;
	}
	public boolean checkforSQLstatements(String first_name, String last_name, String username, String password) {
		return true;
		
	}
	public boolean validateUser(String username, String password) {
		Iterable<employeesEntity> users = employeeCrudRepo.findAll();

		for (employeesEntity user : users) {
			if (user.getUsername().equals(username)) {
				if (user.getPassword().equals(password)) {
					return true;
				}
			}
		}

		return false;

	}

	
	public boolean validateEmployeesEntity(String first_name, String last_name, String username, String password) {
		Iterable<employeesEntity> users = employeeCrudRepo.findAll();
		for (employeesEntity user : users) {
			if (user.getUsername().equals(username)) {
				if (user.getPassword().equals(password)) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	  public boolean checkForBlanks (String input) { 
		  if (StringUtils.isAllBlank(input)) { 
			  return true; 
			  } 
		  if (StringUtils.isAllEmpty(input)) { 
			  return true; 
			  } 
		  if (StringUtils.isWhitespace(input)) {
			  return true; 
			  } 
		  if (StringUtils.containsWhitespace(input)) { 
			  return true; 
			  }
	  
	  return false;
	  
	  }
	 

}
