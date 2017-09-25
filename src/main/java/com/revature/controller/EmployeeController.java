package com.revature.controller;

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
	public List<Employee> getAllEmployee() {
		try {
			logger.info("Getting the Employee data...");
			return employee.getAllEmployee();
		} catch (DataServiceException e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/myteam")
	public List<Employee> getEmpByManagerId(@RequestParam("userid") int managerId) {
		try {
			logger.info("Getting the Employee data...");
			return employee.getEmpListByManagerId(managerId);
		} catch (DataServiceException e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/byempid")
	public List<Employee> getEmpById(@RequestParam("userid") int empid) {
		try {
			logger.info("Getting the Employee data...");
			return employee.getEmpListById(empid);
		} catch (DataServiceException e) {
			e.printStackTrace();
		}
		return null;
	}

	@PostMapping("/releave")
	public Integer releaveEmployee(@RequestBody Employee e) {
		Employee emp = new Employee();
		logger.info("Adding employee data");
		try {
			emp.setReleaving(e.getReleaving());
			emp.setReleavingReason(e.getReleavingReason());
			emp.setId(e.getId());
			return employee.releaveEmployee(emp);
		} catch (DataServiceException ex) {
			ex.printStackTrace();
		}
		return null;

	}

	@PostMapping("/updaterole")
	public Integer updateRole(@RequestBody Employee e) {
		Employee emp = new Employee();
		logger.info("Adding employee data");
		try {
			Role role = new Role();
			role.setId(e.getRoleId().getId());
			emp.setRoleId(role);
			emp.setId(e.getId());
			return employee.updateRoleForEmployee(emp);
		} catch (DataServiceException ex) {
			ex.printStackTrace();
		}
		return null;

	}
	 @GetMapping("/updatedeptbyemp")
	    public Integer updateDept(@RequestParam("empid") int empid,@RequestParam("deptid") int deptid) {
	        Employee emp = new Employee();
	        logger.info("updating employee data");
	        try {
	            emp.setId(empid);
	            Department department=new Department();
	            department.setId(deptid);
	            emp.setDepartmentId(department);
	            return employee.updateDeptForEmployee(emp);
	        } catch (DataServiceException ex) {
	            ex.printStackTrace();
	        }
	        return null;
	    }		
	 @GetMapping("/remleave")
	    public List<Employee> getRemainingLeaves(@RequestParam("empid") Integer id) {
	        try {
	            logger.info("Getting the Employee data...");
	            Employee emp=new Employee();
	            emp.setId(id);
	            return employee.getRemainingLeaves(emp);
	        } catch (DataServiceException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
}
