package com.revature.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name="employees",catalog="lms-app")
public class Employee {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Integer id;

@Column(name="NAME")
private String name;

@Column(name="GENDER")
private String gender;

@OneToOne(targetEntity=Role.class)
@JoinColumn(name="ROLE_ID", referencedColumnName="ID")
private Role roleId;

@Column(name="MANAGER_ID")
private Integer managerId;

@ManyToOne(targetEntity=Department.class)
@JoinColumn(name="DEPARTMENT_ID", referencedColumnName="ID")
private Department departmentId;

@Temporal(TemporalType.DATE)
@Column(name="JOINING_DATE")
private Date joiningDate;

@Temporal(TemporalType.DATE)
@Column(name="RELEAVING_DATE")
private Date releavingDate;

@Column(name="RELEAVING_REASON")
private String releavingReason;


}
