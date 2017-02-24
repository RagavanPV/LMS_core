package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.impl.RoleDAOImpl;
import com.revature.data.impl.UserDAOImpl;
import com.revature.model.Role;
import com.revature.model.User;

@Service
public class RoleServiceImpl {
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Autowired
	private RoleDAOImpl roleDAOImpl;
	
	public List<Role> getAllRoles() throws BusinessServiceException {
		List<Role> roles = null;
		try {
			roles = roleDAOImpl.getAllRoles();
			logger.info("Categories retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return roles;
	}
}
