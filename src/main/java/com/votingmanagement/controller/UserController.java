package com.votingmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.votingmanagement.exception.VoterNotFoundException;
import com.votingmanagement.model.User;
import com.votingmanagement.service.UserService;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/user/get")
	public List<User> getAllUser(){
		return userService.getAllUser();
	}
	
	@DeleteMapping("/user/delete/{userId}")
	public String deleteUser (@PathVariable("userId") Long userId) throws VoterNotFoundException {
		return userService.deleteUser(userId);
	} 
	
	@PutMapping("/user/put/{userId}")
	public User updateUser(@PathVariable ("userId") Long userId, @RequestBody User user) throws VoterNotFoundException {
	return userService.updateUser(userId, user);
	}
	
}
