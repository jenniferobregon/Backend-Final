package com.javafinalproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javafinalproject.models.Post;
import com.javafinalproject.models.User;

@Controller
@RequestMapping("/")
public class RegisterController {


	@GetMapping("/register")
	public String getNewUser(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@GetMapping("/user")
	public String getUser(Model model) {
		model.addAttribute("posts", new Post());
		return "user";

	}
	
	
}
