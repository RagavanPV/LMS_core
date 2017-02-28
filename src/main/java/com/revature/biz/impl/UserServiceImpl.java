package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.exception.DataServiceException;
import com.revature.data.impl.UserDAOImpl;
import com.revature.model.User;

@Service
public class UserServiceImpl{
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private  UserDAOImpl userDAO;
	
	
}
