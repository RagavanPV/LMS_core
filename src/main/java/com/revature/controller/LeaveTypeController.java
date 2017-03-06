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

import com.revature.biz.impl.LeaveTypeServiceImpl;
import com.revature.data.exception.DataServiceException;
import com.revature.model.LeaveType;

@RestController
@RequestMapping("/leavetype")
public class LeaveTypeController {
	private static Logger logger = Logger.getLogger(LeaveTypeController.class);
	@Autowired
	private LeaveTypeServiceImpl leaveTypeService;

	@GetMapping("/")
	public List<LeaveType> getAllDepartment(@RequestParam("gender") String gender) {
		try {
			return leaveTypeService.list(gender);
		} catch (DataServiceException e) {
			e.printStackTrace();
		}
		return null;
	}

	@PostMapping("/update")
	public Integer updateLeaveType(@RequestBody LeaveType type) {
		try {
			LeaveType leaveType = new LeaveType();
			leaveType.setCode(type.getCode());
			leaveType.setName(type.getName());
			leaveType.setId(type.getId());
			return leaveTypeService.updateLeaveType(leaveType);
		} catch (DataServiceException e) {
			e.printStackTrace();
		}
		return null;
	}
}