package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.model.User;

@Repository
@Primary
public class UserDAOImpl{
	private static Logger logger = Logger.getLogger(UserDAOImpl.class);
	
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}
	
	public List<User> getAllUser() throws DataServiceException{
		
		StringBuilder stringBuilder=new StringBuilder("select u.id userid,u.email_id useremail,e.name ename,e.role_id roleId from users u join employees e on u.employee_id=e.id");
		List<User> users = null;
		try {
			users = dataRetriver.retrieveListBySQL(stringBuilder.toString());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
	
		logger.info("Categories data retrieval success..");

		return users;
		
		
	}
	
	public List<User> getUser(String emailId,String password) throws DataServiceException{
		
		StringBuilder stringBuilder=new StringBuilder("select u.id userid,u.email_id useremail from users u where email_id='"+emailId+"' and password='"+password+"'");
		List<User> users = null;
		try {
			users = dataRetriver.retrieveListBySQL(stringBuilder.toString());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
	
		logger.info("Categories data retrieval success..");

		return users;
		
		
	}
	

}
