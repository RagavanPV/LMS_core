package com.revature.dto;

import java.sql.Date;

import lombok.Data;
@Data
public class FullDayLeaveDTO {
private EmployeeDTO empDTO;
private LeaveTypeDTO leaveDTO;
private Date fromDate;
private Date toDate;
private String reason;

}
