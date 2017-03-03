package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    private LeaveTypeServiceImpl leaveType;
  @GetMapping("/")
    public List<LeaveType> getAllDepartment(@RequestParam("gender") String gender){
        try {
        	System.out.println(gender);
            return leaveType.list(gender);
        } catch (DataServiceException e) {
            e.printStackTrace();
        }
        return null;
    }
}