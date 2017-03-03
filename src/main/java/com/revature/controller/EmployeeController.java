package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.impl.EmployeeServiceImpl;
import com.revature.data.exception.DataServiceException;
import com.revature.model.Employee;

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
	@GetMapping("/myteam")
    public List<Employee> getEmpByManagerIdController(@RequestParam("userid") int managerId) {
        try {
            logger.info("Getting the Employee data...");
            return employee.getEmpListByManagerId(managerId);
                    } catch (DataServiceException e) {
            e.printStackTrace();
        }
        return null;
}
}
