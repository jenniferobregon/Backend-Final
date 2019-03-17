package com.javafinalproject.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javafinalproject.models.Post;
import com.javafinalproject.repositories.PostRepository;

@Controller
@RequestMapping({ "/post" })
public class DisplayPostsController {
	
	@Autowired
	PostRepository postRepository;
	
	@GetMapping()
    public String getAllPosts(Model model) {
        List<Post> posts = new ArrayList<Post>();

        // Code to query the database and
        // add Posts to the List will go here
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:sqlite:./finalData.db", "", "");
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM posts");
            
            // access each row in the table
            while (rs.next()) {
                // create a new Post object 
                Post newPosts = new Post();
                // get the values from each column of the current row and add them to the new Post
                newPosts.setID(rs.getInt("ID"));
                newPosts.setAuthorID(rs.getInt("authorID"));
                newPosts.setTimeStamp(rs.getString("timeStamp"));
                newPosts.setMessage(rs.getString("message"));
                // add the new album to the albums list
                posts.add(newPosts);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        model.addAttribute("posts", posts);

        return "posts";
    }
}

