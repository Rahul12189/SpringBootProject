package com.mybootproject.playground.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mybootproject.playground.model.UserInfo;
import com.mybootproject.playground.repository.UserRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class UserController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	@PostMapping("/user")
	public UserInfo postUser(@RequestBody UserInfo user) {
		String clearPassword = user.getPassword();
		String encodedPassword = passwordEncoder.encode(clearPassword);
		user.setPassword(encodedPassword);
		return userRepository.save(user);
	}
	
	@GetMapping("/login")  
	public UserInfo login(Principal principal) {
		String username = principal.getName();
		return userRepository.getByUsername(username);
	}
}
