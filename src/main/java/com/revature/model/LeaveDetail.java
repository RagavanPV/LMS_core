/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Akshay
 */
@Entity
@Table(name = "leave_details")

public class LeaveDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "DATE_OF_LEAVE")
    @Temporal(TemporalType.DATE)
    private Date dateOfLeave;
    @Basic(optional = false)
    @Column(name = "APPLIED_DATE")
    @Temporal(TemporalType.DATE)
    private Date appliedDate;
    @Basic(optional = false)
    @Column(name = "SESSION")
    private Character session;
    @Basic(optional = false)
    @Lob
    @Column(name = "REASON")
    private String reason;
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @JoinColumn(name = "LEAVE_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private LeaveType leaveTypeId;
    @JoinColumn(name = "STATUS", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private LeaveStatus status;
    @JoinColumn(name = "HANDLED_BY", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Employee handledbyid;

    public LeaveDetail() {
    }


   
}
