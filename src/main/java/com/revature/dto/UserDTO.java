package com.revature.dto;


import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserDTO {
private Integer id;
private String emailId;
private String password;
private String activationCode;
private Boolean isActive;
private LocalDateTime lastLogin;
}
