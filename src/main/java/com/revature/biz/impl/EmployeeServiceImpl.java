package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.exception.DataServiceException;
import com.revature.data.impl.EmployeeDAOImpl;
import com.revature.model.Department;
import com.revature.model.Employee;

@Service
public class EmployeeServiceImpl {
	private static Logger logger = Logger.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private  EmployeeDAOImpl employeeDAO;
	
	public List<Employee> getAllEmployee() throws DataServiceException {
		List<Employee> employee=null;
		employee=employeeDAO.getAllEmployees();
		logger.info("retrived successfully");
		return employee;
	}
	public Integer addEmployee(Employee employee) throws DataServiceException {
		int rows=employeeDAO.addEmployee(employee);
		logger.info("Added Employee");
		return rows;
	}
	public Integer releaveEmployee(Employee employee) throws DataServiceException {
		int rows=employeeDAO.releaveEmployee(employee);
		logger.info("Releave Employee");
		return rows;
	}
	public Integer updateRole(Employee employee) throws DataServiceException {
		int rows=employeeDAO.updateRole(employee);
		logger.info("Updated Role for employee");
		return rows;
	}
}
