package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.impl.DepartmentDAOImpl;
import com.revature.data.impl.EmployeeDAOImpl;
import com.revature.model.Department;
import com.revature.model.Employee;

@Service
public class DepartmentServiceImpl {
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Autowired
	private DepartmentDAOImpl departmentDAOImpl;
	
	public List<Department> getAllDepartments() throws BusinessServiceException {
		List<Department> departments = null;
		try {
			departments = departmentDAOImpl.getAllDepartments();
			logger.info("Categories retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return departments;
	}
}
