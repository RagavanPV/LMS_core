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

import com.revature.biz.impl.LeaveDetailsServiceImpl;
import com.revature.data.exception.DataServiceException;
import com.revature.model.Department;
import com.revature.model.Employee;
import com.revature.model.LeaveDetail;

@RestController
@RequestMapping("/leavedetail")
public class LeaveDetailsController {
	private static Logger logger = Logger.getLogger(LeaveDetailsController.class);

	@Autowired
	private LeaveDetailsServiceImpl leaveDetailsServiceImpl;
	
	@GetMapping("/")
	public List<LeaveDetail> getAllDepartment(){
		try {
			return leaveDetailsServiceImpl.getAll();
		} catch (DataServiceException e) {
			e.printStackTrace();
		}
		return null;
	}
	@GetMapping("/byempid")
	public List<LeaveDetail> getLeaveByEmployeeId(@RequestParam("empid") Integer empid){
		try {
			LeaveDetail detail=new LeaveDetail();
			Employee emp=new Employee();
			emp.setId(empid);
			detail.setEmployeeId(emp);
			return leaveDetailsServiceImpl.getLeaveByEmployeeId(detail);
		} catch (DataServiceException e) {
			e.printStackTrace();
		}
		return null;
	}

}
