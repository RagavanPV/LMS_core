package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.impl.DepartmentServiceImpl;
import com.revature.data.exception.DataServiceException;
import com.revature.model.Department;

@RestController
@RequestMapping("/department")
public class DepartmentController {
private static Logger logger = Logger.getLogger(UserController.class);

	
	@Autowired
	private DepartmentServiceImpl department;
	
	@GetMapping
	public List<Department> getAllDepartment(){
		try {
			return department.getAllDepartment();
		} catch (DataServiceException e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/one")
	public Department index(@RequestParam("id") int id){
		try {
			return department.getDepartmentById(id);
		} catch (DataServiceException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
