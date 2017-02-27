package com.revature.dto;

import java.util.Date;

import lombok.Data;

@Data
public class LeaveDetailDTO {
private Integer id;
private EmployeeDTO employeeId;
private LeaveTypeDTO leaveTypeId;
private Date dateOfLeave;
private String session;
private String reason;
private String status;

}
