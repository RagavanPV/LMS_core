package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.revature.biz.impl.DepartmentServiceImpl;
import com.revature.data.exception.DataServiceException;
import com.revature.data.impl.DepartmentDAOImpl;
import com.revature.model.Department;

@RestController
@RequestMapping("/department")
public class DepartmentController {
private static Logger logger = Logger.getLogger(UserController.class);

	
	@Autowired
	private DepartmentServiceImpl department;
	@Autowired
	private DepartmentDAOImpl dep;
	
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
	@PostMapping("/add")
	public Integer addDepartment(@RequestBody Department d){
		try {
			Department depart=new Department();
			depart.setCode(d.getCode());
			depart.setName(d.getName());
			return department.addDepartment(depart);
		} catch (DataServiceException e) {
			e.printStackTrace();
		}
		return null;
	}
	@PostMapping("/call")
	public String callProcedure(@RequestBody Department d){
		String jsonObject = null;
		String msg = null;
		JSONObject obj = null;
		try {
			Department depart=new Department();
			depart.setCode(d.getCode());
			depart.setName(d.getName());
		   msg=department.callProcedure(depart);
		   obj=new JSONObject();
		   obj.put("errmsg",msg);
		   System.out.println(obj);
          
		  jsonObject=obj.toString();
//		   String a=gson.toJson(msg);
		   
		} catch (DataServiceException e) {
			e.printStackTrace();
		}
		
		return jsonObject;
	}
	
	
}
