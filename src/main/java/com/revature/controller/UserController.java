package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.impl.UserServiceImpl;
import com.revature.data.exception.DataServiceException;
import com.revature.model.User;

@RestController
@RequestMapping("/user")
public class UserController {

	private static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserServiceImpl user;

	@GetMapping
	public ResponseEntity<List<User>> getAllUsersController() {
		List<User> userList=null;
		ResponseEntity<List<User>> entity=new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		try {
			userList= user.getAllUsers();
			entity=new ResponseEntity<>(userList, HttpStatus.OK);
		} catch (DataServiceException e) {
			e.printStackTrace();
		}
		return entity;
		
	}
	@GetMapping("/GetUser")
	public ResponseEntity<List<User>> getUserController(@RequestParam("emailId")String emailId,@RequestParam("password") String password) {
		List<User> userList=null;
		ResponseEntity<List<User>> entity=new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		try {
			userList= user.getUser(emailId,password);
			entity=new ResponseEntity<>(userList, HttpStatus.OK);
		} catch (DataServiceException e) {
			e.printStackTrace();
		}
		return entity;
		
	}
	@PostMapping("/updatepassword")
	public Integer updatePassword(@RequestBody User u) {
		User users=new User();
		Integer rows = null;
		users.setUserPassword(u.getUserPassword());
		users.setEmailId(u.getEmailId());;
		try {
		rows=user.updatePassword(users);
		} catch (DataServiceException e) {
			e.printStackTrace();
		}
		return rows;

	}
}