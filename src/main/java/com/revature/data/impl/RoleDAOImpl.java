package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.Department;
import com.revature.model.Role;
@Transactional
@Repository
public class RoleDAOImpl {
	private static Logger logger = Logger.getLogger(UserDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	public List<Role> getAllRoles() throws DataServiceException{
		List<Role> roles = null;
		try {
			StringBuilder sb = new StringBuilder("select * from roles");
			roles = dataRetriver.retrieveListBySQL(sb.toString());
			logger.info("data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return roles;
	}
	public Integer addRole(Role role) throws DataServiceException {
		StringBuilder stringBuilder = new StringBuilder("insert into roles(CODE,NAME,LEVEL) values('"+role.getCode()+"','"+role.getRole()+"','"+role.getLevel()+"')");
		
		Integer rows = null;
		try {
			rows = dataRetriver.add(stringBuilder.toString());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		logger.info("Department data retrieval success..");
		return rows;
	}
}
