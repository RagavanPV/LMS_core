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
@Table(name="leave_types",catalog="lms-app")
public class LeaveType {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Integer id;
@Column(name="CODE")
private String code;
@Column(name="NAME")

private String name;

}
