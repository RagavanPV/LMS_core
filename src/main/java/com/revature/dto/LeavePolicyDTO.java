package com.revature.dto;


import lombok.Data;

@Data
public class LeavePolicyDTO {
private Integer id;
private PolicyDTO policyId;
private RoleDTO roleId;
private LeaveTypeDTO leaveTypeId;
private Integer noOfDays;


}
