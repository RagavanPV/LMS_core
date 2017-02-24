package com.revature.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name="leave_details",catalog="lms-app")
public class LeaveDetail {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Integer id;

@ManyToOne(targetEntity=Employee.class)
@JoinColumn(name="EMPLOYEE_ID", referencedColumnName="ID")
private Employee employeeId;

@ManyToOne(targetEntity=LeaveType.class)
@JoinColumn(name="LEAVE_TYPE_ID", referencedColumnName="ID")
private LeaveType leaveTypeId;

@Temporal(TemporalType.DATE)
@Column(name="DATE_OF_LEAVE")
private Date dateOfLeave;
@Column(name="SESSION")
private String session;
@Column(name="REASON")

private String reason;
@Column(name="STATUS")

private String status;

}
