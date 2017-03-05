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
import com.revature.model.Employee;
@Transactional
@Repository
public class EmployeeDAOImpl {
	private static Logger logger = Logger.getLogger(UserDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	public List<Employee> getAllEmployees() throws DataServiceException{
		List<Employee> employees = null;
		try {
			StringBuilder sb = new StringBuilder("select * from employees");
			employees = dataRetriver.retrieveListBySQL(sb.toString());
			logger.info("Categories data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return employees;
	}
	public Integer addEmployee(Employee employee) throws DataServiceException {
		StringBuilder stringBuilder = new StringBuilder("insert into employees(NAME,GENDER,ROLE_ID,MANAGER_ID,DEPARTMENT_ID,JOINING_DATE) values('"+employee.getEmployee()+"','"+employee.getGender()+"','"+employee.getRoleId().getId()+"','"+employee.getManagerId()+"','"+employee.getDepartmentId().getId()+"','"+employee.getJoining()+"')");
		
		Integer rows = null;
		try {
			rows = dataRetriver.add(stringBuilder.toString());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		logger.info("Employee data added");
		return rows;
	}
	public Integer releaveEmployee(Employee employee) throws DataServiceException {
		StringBuilder stringBuilder = new StringBuilder("update employees set releaving_date='"+employee.getReleaving()+"',releaving_reason='"+employee.getReleavingReason()+"' where id='"+employee.getId()+"'");
		
		Integer rows = null;
		try {
			rows = dataRetriver.update(stringBuilder.toString());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		logger.info("Employee Releaved");
		return rows;
	}
	public Integer updateRole(Employee employee) throws DataServiceException {
		StringBuilder stringBuilder = new StringBuilder("update employees set role_id='"+employee.getRoleId().getId()+"' where id='"+employee.getId()+"'");
		
		Integer rows = null;
		try {
			rows = dataRetriver.update(stringBuilder.toString());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		logger.info("Employee data added");
		return rows;
	}
}
