package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="leave_status",catalog="lms-app")
public class LeaveStatus {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Integer id;

@Column(name="NAME")
private String name;

}
