package com.revature.controller;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.impl.ApplyLeaveServiceImpl;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.dto.EmployeeDTO;
import com.revature.dto.FullDayLeaveDTO;
import com.revature.dto.HalfDayLeaveDTO;
import com.revature.dto.LeaveTypeDTO;

@RestController
@RequestMapping("/leave")
public class LeaveController {
	private static Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	ApplyLeaveServiceImpl applyLeav;
	@PostMapping("/fullDay")
	public String fullDay(@RequestBody FullDayLeaveDTO leaveDTO){
		
		String result;
		try {
			FullDayLeaveDTO leav=new FullDayLeaveDTO();
			EmployeeDTO empDTO=new EmployeeDTO();
			LeaveTypeDTO lvDTO=new LeaveTypeDTO();
			empDTO.setId(leaveDTO.getEmpDTO().getId());
			lvDTO.setId(leaveDTO.getLeavDTO().getId());
			leav.setEmpDTO(empDTO);
			leav.setLeavDTO(lvDTO);
			leav.setFromDate(leaveDTO.getFromDate());
			leav.setToDate(leaveDTO.getToDate());
			leav.setReason(leaveDTO.getReason());
			System.out.println(leav);
			result=applyLeav.applyFullDayLeave(leav);
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("ERRMSG", result);
			String jsonResult=jsonObject.toString();
			return jsonResult;
		} catch (DataServiceException | DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	@PostMapping("/halfDay")
	public String halfDay(@RequestBody HalfDayLeaveDTO leaveDTO){
		String result;
		try {
			HalfDayLeaveDTO leav=new HalfDayLeaveDTO();
			EmployeeDTO empDTO=new EmployeeDTO();
			LeaveTypeDTO lvDTO=new LeaveTypeDTO();
			empDTO.setId(leaveDTO.getEmpDTO().getId());
			lvDTO.setId(leaveDTO.getLeavDTO().getId());
			leav.setEmpDTO(empDTO);
			leav.setLeavDTO(lvDTO);
			leav.setFromDate(leaveDTO.getFromDate());
			leav.setSession(leaveDTO.getSession());
			leav.setReason(leaveDTO.getReason());
			result=applyLeav.applyHalfDayLeave(leav);
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("ERRMSG", result);
			String jsonResult=jsonObject.toString();
			return jsonResult;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
