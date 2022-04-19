package com.first.springrest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.first.springrest.service.UserService;

@RestController
public class UserController {

	private  UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	// build create user rest  api 
	@PostMapping()
	// @RequestBody allows us to retreive the request body and automattically convert it to java object
	public ResponseEntity<User>  saveUser( @RequestBody User user) {
		return new ResponseEntity<User>(userService.saveUser(user),HttpStatus.CREATED);
	}
