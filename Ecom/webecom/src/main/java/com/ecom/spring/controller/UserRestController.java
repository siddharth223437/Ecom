package com.ecom.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.common.vo.PrimaryTransaction;
import com.ecom.common.vo.User;
import com.ecom.service.AccountServices;
import com.ecom.service.UserService;

@RestController
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AccountServices accountServices;
	
	@PostMapping("/register")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		if(user!=null) {
		userService.registerUser(user);
		return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
	
}
