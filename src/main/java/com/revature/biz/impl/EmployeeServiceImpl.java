package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.exception.DataServiceException;
import com.revature.data.impl.EmployeeDAOImpl;
import com.revature.model.Employee;

@Service
public class EmployeeServiceImpl {
	private static Logger logger = Logger.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private  EmployeeDAOImpl employeeDAO;
	
	public List<Employee> list() throws DataServiceException {
		List<Employee> employee=null;
		employee=employeeDAO.getAllEmployees();
		logger.info("retrived successfully");
		return employee;
	}
}
