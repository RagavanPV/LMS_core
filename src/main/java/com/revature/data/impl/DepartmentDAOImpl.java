package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.model.Department;

@Repository
@Primary
public class DepartmentDAOImpl {
	private static Logger logger = Logger.getLogger(UserDAOImpl.class);

	@Autowired
	private DataRetriver dataRetriver;

	final ObjectMapper mapper = new ObjectMapper();

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	public List<Department> getAllDepartment() throws DataServiceException {
		StringBuilder stringBuilder = new StringBuilder("select * from departments");
		List<Department> department = null;
		try {
			department = dataRetriver.retrieveListBySQL(stringBuilder.toString());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		logger.info("Department data retrieval success..");
		return department;
	}

	public Department getDepartmentById(int id) throws DataServiceException {
		StringBuilder stringBuilder = new StringBuilder("select * from departments where id=" + id);
		Object department = null;
		Department departmentModel = new Department();
		try {
			department = dataRetriver.retrieveOneBySQL(stringBuilder.toString());
			System.out.println(department);
			
			departmentModel = mapper.convertValue(department, Department.class);
			System.out.println(departmentModel);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		logger.info("Department data retrieval success..");
		return departmentModel;
	}
	public Integer addDepartment(Department department) throws DataServiceException {
		StringBuilder stringBuilder = new StringBuilder("insert into departments(CODE,NAME) values('"+department.getCode()+"','"+department.getName()+"')");
		
		Integer rows = null;
		try {
			rows = dataRetriver.add(stringBuilder.toString());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		logger.info("Department data added");
		return rows;
	}
	public String callProcedure(Department department) throws DataServiceException {
		StringBuilder stringBuilder = new StringBuilder("PR_TEST");
		
		String rows = null;
		try {
			rows = dataRetriver.callProcedure(stringBuilder.toString(),department);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		logger.info("Department data added");
		return rows;
	}
	public Integer update(Department department) throws DataServiceException {
		StringBuilder stringBuilder = new StringBuilder("update departments set code='"+department.getCode()+"',name='"+department.getName()+"' where id='"+department.getId()+"'");
		
		Integer rows = null;
		try {
			rows = dataRetriver.update(stringBuilder.toString());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		logger.info("Department data added");
		return rows;
	}
	
}
