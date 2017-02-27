package com.revature.dto;

import java.util.Date;

import lombok.Data;

@Data
public class EmployeeDTO {
private Integer id;
private UserDTO userId;
private String name;
private String gender;
private int roleId;
private Integer managerId;
private DepartmentDTO departmentId;
private Date joiningDate;
private Date releavingDate;
private String releavingReason;


}
