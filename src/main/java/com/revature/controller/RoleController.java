package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.impl.RoleServiceImpl;
import com.revature.controller.exception.InternalException;
import com.revature.model.Role;

@RestController
@RequestMapping("/role")
public class RoleController {
	private static Logger logger = Logger.getLogger(HolidayController.class);

	@Autowired
	private RoleServiceImpl roleService;

	@GetMapping("/")
	public List<Role> getAllHolidayController() {
		List<Role> role = null;
		try {
			logger.info("Getting the Holiday data...");
			role = roleService.getAllRoles();
			logger.info("Holiday data retrieval success.");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return role;
	}
}
