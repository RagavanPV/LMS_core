package com.revature.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.impl.EmployeeServiceImpl;
import com.revature.data.exception.DataServiceException;
import com.revature.model.Department;
import com.revature.model.Employee;
import com.revature.model.Role;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private EmployeeServiceImpl employee;

	@GetMapping("/")
	public List<Employee> getAllEmployeeController() {
		try {
			logger.info("Getting the Employee data...");
			return employee.getAllEmployee();
		} catch (DataServiceException e) {
			e.printStackTrace();
		}
		return null;
	}
	@PostMapping("/add")
	public Integer addEmployee(@RequestBody Employee e)
	{
		Employee emp=new Employee();
		logger.info("Adding employee data");
		try {
			emp.setEmployee(e.getEmployee());
			emp.setGender(e.getGender());
			Role role=new Role();
			role.setId(e.getRoleId().getId());
			emp.setRoleId(role);
			emp.setManagerId(e.getManagerId());
			Department dep=new Department();
			dep.setId(e.getDepartmentId().getId());
			emp.setDepartmentId(dep);
			emp.setJoining(e.getJoining());
			return employee.addEmployee(emp);
		} catch (DataServiceException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return null;

	}
	@PostMapping("/releave")
	public Integer releaveEmployee(@RequestBody Employee e)
	{
		Employee emp=new Employee();
		logger.info("Adding employee data");
		try {
			emp.setReleaving(e.getReleaving());
			emp.setReleavingReason(e.getReleavingReason());
			emp.setId(e.getId());
			return employee.releaveEmployee(emp);
		} catch (DataServiceException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return null;

	}
	@PostMapping("/updaterole")
	public Integer updateRole(@RequestBody Employee e)
	{
		Employee emp=new Employee();
		logger.info("Adding employee data");
		try {
			Role role=new Role();
			role.setId(e.getRoleId().getId());
			emp.setRoleId(role);
			emp.setId(e.getId());
			return employee.updateRole(emp);
		} catch (DataServiceException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return null;

	}
}
