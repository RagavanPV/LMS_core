package com.revature.data.impl;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.Query;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.dto.UserDTO;
import com.revature.model.User;

@Repository
@Primary
public class UserDAOImpl{
	private static Logger logger = Logger.getLogger(UserDAOImpl.class);
	
	@Autowired
	private EntityManager entityManager;
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}
	
	public List<User> list() throws DataServiceException{
		
		StringBuilder stringBuilder=new StringBuilder("select u.id userid,u.email_id useremail,e.name ename from users u join employees e on u.employee_id=e.id");
		List<User> users = null;
		try {
			users = dataRetriver.retrieveBySQL(stringBuilder.toString());
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		logger.info("Categories data retrieval success..");

		return users;
		
		
	}
	
	
	
}
