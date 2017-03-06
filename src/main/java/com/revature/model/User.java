package com.revature.model;

import java.io.Serializable;
import java.util.Date;

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

@Table(name = "users")

public class User implements Serializable{

	  private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "ID")
	    private Integer id;
	    @Basic(optional = false)
	    @Column(name = "EMAIL_ID")
	    private String emailId;
	    @Basic(optional = false)
	    @Lob
	    @Column(name = "USER_PASSWORD")
	    private String userPassword;
	    @Basic(optional = false)
	    @Column(name = "ACTIVATION_CODE")
	    private String activationCode;
	    @Basic(optional = false)
	    @Column(name = "IS_ACTIVE")
	    private boolean isActive;
	    @Basic(optional = false)
	    @Column(name = "LAST_LOGIN")
	    @Temporal(TemporalType.DATE)
	    private Date lastLogin;
	    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID")
	    @ManyToOne(optional = false)
	    private Employee employeeId;

	    public User() {
	    }

}
