package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.EmailService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailService emailService;

    // Register new user
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {

        userRepository.save(user);

        return "User registered successfully!";
    }

    // Get all users
    @GetMapping("/all")
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @GetMapping("/test-email")
    public String testEmail() {

    	List<User> users = userRepository.findAll();

    	for (User user : users) {

    	    emailService.sendReminderEmail(user.getEmail());

    	}


        return "Email sent!";
    }


}
