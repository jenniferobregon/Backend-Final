package com.javafinalproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javafinalproject.models.User;
import com.javafinalproject.repositories.UserRepository;

@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postUser(@ModelAttribute User user) {
		userRepository.save(user);
		return "Successfully created a user: " +"<br>"
				+ ""+ "<b>ID: </b>" + user.getId()+ " <b>First Name: </b>"
						+ "" + user.getFirstName()+" <b>Last Name: </b>"
								+ "" + user.getLastName()+" <b>Username: </b>"
										+ "" + user.getUsername();
	}
	

}
