package com.revature.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="leave_policy",catalog="lms-app")
public class LeavePolicy {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Integer id;

@ManyToOne(targetEntity=Policy.class)
@JoinColumn(name="POLICY_ID",referencedColumnName="ID")
private Policy policyId;

@ManyToOne(targetEntity=Role.class)
@JoinColumn(name="ROLE_ID",referencedColumnName="ID")
private Role roleId;

@ManyToOne(targetEntity=LeaveType.class)
@JoinColumn(name="LEAVE_TYPE_ID",referencedColumnName="ID")
private LeaveType leaveTypeId;

@Column(name="NO_OF_DAYS")
private Integer noOfDays;


}
