package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.impl.EmployeeDAOImpl;
import com.revature.data.impl.HolidayDAOImpl;
import com.revature.model.Employee;
import com.revature.model.Holiday;

@Service
public class EmployeeServiceImpl {
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Autowired
	private EmployeeDAOImpl employeeDAOImpl;
	
	public List<Employee> getAllEmployees() throws BusinessServiceException {
		List<Employee> employees = null;
		try {
			employees = employeeDAOImpl.getAllEmployees();
			logger.info("Categories retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return employees;
	}
}
