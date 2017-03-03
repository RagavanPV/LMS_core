package com.revature.dto;

import java.sql.Date;

import lombok.Data;
@Data
public class HalfDayLeaveDTO {
	private EmployeeDTO empDTO;
	private LeaveTypeDTO leavDTO;
	private Date fromDate;
	private Character session;
	private String reason;
	
}
