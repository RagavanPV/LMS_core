package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.impl.LeaveTypeServiceImpl;
import com.revature.data.exception.DataServiceException;
import com.revature.model.LeaveType;
import com.revature.model.Role;

@RestController
@RequestMapping("/leavetype")
public class LeaveTypeController {
	private static Logger logger = Logger.getLogger(LeaveTypeController.class);
   @Autowired
	private LeaveTypeServiceImpl l;
   @GetMapping("/")
	public List<LeaveType> getAllDepartment(){
		try {
			return l.list();
		} catch (DataServiceException e) {
			e.printStackTrace();
		}
		return null;
	}
   @PostMapping("/add")
	public Integer addDepartment(@RequestBody LeaveType type){
		try {
			LeaveType leaveType=new LeaveType();
			leaveType.setCode(type.getCode());
			leaveType.setName(type.getName());
			return l.add(leaveType);
		} catch (DataServiceException e) {
			e.printStackTrace();
		}
		return null;
	}
   @GetMapping("/M")
  	public List<LeaveType> getleaveM(){
  		try {
  			return l.listM();
  		} catch (DataServiceException e) {
  			e.printStackTrace();
  		}
  		return null;
  	}
   @GetMapping("/F")
 	public List<LeaveType> getleaveF(){
 		try {
 			return l.listF();
 		} catch (DataServiceException e) {
 			e.printStackTrace();
 		}
 		return null;
 	}
}
