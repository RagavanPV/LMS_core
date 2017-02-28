package com.revature.data.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.User;

@Transactional
@Repository
public class UserDAOImpl{
	private static Logger logger = Logger.getLogger(UserDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;
	@Autowired
	private EntityManager entityManager;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	public List<User> getAllUsers(){
		List<User> users = null;
		StringBuilder sb = new StringBuilder("select * from users");
		users = entityManager.createNativeQuery(sb.toString(),User.class).getResultList();
		logger.info("data retrieval success..");
		return users;
	}
	public List<User> listUser(User user) throws DataServiceException{
		List<User> categories = null;
		
		try {
			StringBuilder sb = new StringBuilder("select * from users where EMAIL_ID='"+user.getEmailId()+"'");
			categories = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Categories data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return categories;
	}
	public List<User> validateLogin(User user) throws DataServiceException{
		List<User> list=null;
		try {
			StringBuilder sb = new StringBuilder("select * from users where EMAIL_ID='"+user.getEmailId()+"'");
			list=dataRetriver.retrieveBySQL(sb.toString());
			System.out.println(list.get(0));
//			use=(User)list;
//			if(u.getPassword().equals(user.getPassword())){
//				isValid=true;
//			}
			logger.info("Categories data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			System.out.println(e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return list;
	}
	
	
	
}
