package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public List<User> getAllUsersController() {
		try {
			return user.getAllUsers();
		} catch (DataServiceException e) {
			e.printStackTrace();
		}
		return null;
	}
}