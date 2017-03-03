package com.revature.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID")
	private Integer id;
	@Basic(optional = false)
	@Column(name = "NAME")
	private String employee;
	@Basic(optional = false)
	@Column(name = "GENDER")
	private Character gender;
	@Column(name = "MANAGER_ID")
	private Integer managerId;
	@Basic(optional = false)
	@Column(name = "JOINING_DATE")
	private Date joining;
	@Column(name = "RELEAVING_DATE")
	private Date releaving;
	@Lob
	@Column(name = "RELEAVING_REASON")
	private String releavingReason;
	@JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "ID")
	@ManyToOne(optional = false)
	private Department departmentId;
	@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
	@ManyToOne(optional = false)
	private Role roleId;

	public Employee() {
	}
}
