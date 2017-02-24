package com.revature.model;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="users",catalog="lms-app")
public class User {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Integer id;
@Column(name="EMAIL_ID")
private String emailId;
@Column(name="PASSWORD")

private String password;
@Column(name="ACTIVATION_CODE")

private String activationCode;
@Column(name="IS_ACTIVE")

private Boolean isActive;
@Column(name="LAST_LOGIN")
private LocalDateTime lastLogin;
}
