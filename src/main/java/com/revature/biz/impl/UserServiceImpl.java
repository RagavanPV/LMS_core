package com.revature.biz.impl;

import java.util.List;

import org.apache.commons.mail.EmailException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.exception.DataServiceException;
import com.revature.data.impl.UserDAOImpl;
import com.revature.model.User;

@Service
public class UserServiceImpl {
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDAOImpl userDAO;

	public List<User> getAllUsers() throws DataServiceException {
		List<User> list = null;
		list = userDAO.getAllUser();
		logger.info("retrived successfully");
		return list;
	}

	public List<User> getUser(String emailId, String password) throws DataServiceException {
		List<User> list = null;
		list = userDAO.getUser(emailId, password);
		logger.info("retrived successfully");
		return list;
	}

    public Integer forgotPassword(User user) throws DataServiceException, EmailException {
        int rows=userDAO.forgotPassword(user);
        logger.info("password updated");
        return rows;
    }
}
