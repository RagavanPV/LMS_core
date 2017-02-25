package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.impl.UserServiceImpl;
import com.revature.controller.exception.InternalException;
import com.revature.model.User;

@RestController
@RequestMapping("/users")
public class UserController {

	private static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserServiceImpl categoryService;

	@GetMapping("/list/all")
	public List<User> getActiveCategoriesController() {
		List<User> categories = null;
		try {
			logger.info("Getting the categories data...");
			categories = categoryService.list();
			logger.info("categories data retrieval success.");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return categories;
	}
}