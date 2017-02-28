package com.revature.data.impl;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.Query;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.revature.data.exception.DataServiceException;
import com.revature.model.User;

@Repository
@Primary
public class UserDAOImpl{
	private static Logger logger = Logger.getLogger(UserDAOImpl.class);
	
	@Autowired
	private EntityManager entityManager;




	
	public List<User> list() throws DataServiceException{
		
		Query q=entityManager.createNativeQuery("SELECT * FROM users",User.class);
		List<User> users=q.getResultList();
	
		logger.info("Categories data retrieval success..");

		return users;
		
		
	}
	
	
	
}
