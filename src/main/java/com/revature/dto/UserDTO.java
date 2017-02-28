package com.revature.dto;


import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;

@Data
public class UserDTO {
private Integer id;
private String emailId;
private String password;
private String activationCode;
private Boolean isActive;
private Date lastLogin;
} 
