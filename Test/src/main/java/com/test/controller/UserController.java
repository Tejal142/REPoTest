package com.test.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.User;
import com.test.service.UserService;

	@RestController
	public class UserController {

		@Autowired
		private UserService userService;
	
		
		@GetMapping(value="/userDetailsData", produces=MediaType.APPLICATION_JSON_VALUE)
		public Set<User> getAllUsersData(@RequestBody List<User> usersReq) {
			List<User> userData =  usersReq;
						
			List<User> userDataRes = this.userService.getAllUsersData();
			Set<User> inputSet = new HashSet<User>(userDataRes);
			return inputSet;
		}
		
		
		@PutMapping(value="/user/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, 
				produces=MediaType.APPLICATION_JSON_VALUE)
		public User update(@RequestBody User user, @PathVariable("id") String uId) {
			user = this.userService.update(user, Long.parseLong(uId));
			return user;
		}
		
	}
