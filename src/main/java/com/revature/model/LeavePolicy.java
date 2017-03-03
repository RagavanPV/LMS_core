/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

/**
 *
 * @author Akshay
 */
@Entity
@Table(name = "leave_policy")
@Data
public class LeavePolicy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NO_OF_DAYS")
    private int noOfDays;
    @JoinColumn(name = "LEAVE_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private LeaveType leaveTypeId;
    @JoinColumn(name = "POLICY_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Policy policyId;
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Role roleId;

    public LeavePolicy() {
    }

    
}
