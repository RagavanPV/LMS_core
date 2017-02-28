package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.impl.UserServiceImpl;
import com.revature.controller.exception.InternalException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.impl.UserDAOImpl;
import com.revature.dto.UserDTO;
import com.revature.model.User;

@RestController
@RequestMapping("/users")
public class UserController {

	private static Logger logger = Logger.getLogger(UserController.class);

	
	@Autowired
	private UserDAOImpl user;

	@GetMapping
	public List<User> index(){
		try {
			return user.list();
		} catch (DataServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
}