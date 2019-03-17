package com.javafinalproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javafinalproject.models.Post;
import com.javafinalproject.repositories.PostRepository;

@RestController
@RequestMapping("/")
public class PostController {

	@Autowired
	PostRepository postRepository;
	

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String postMessage(@ModelAttribute Post message) {
		postRepository.save(message);
		return "Successfully created a post: " + "<br>" + "<b>ID:</b> " + message.getID() + " <b>AuthorID: </b>"
				+ message.getAuthorID() + " <b>Timespamp: </b>" + message.getTimeStamp() + " <b>Message:</b> "
				+ message.getMessage();

	}
	
	
}