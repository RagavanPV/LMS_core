package com.revature.model;


import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.NamedQueries;

import lombok.Data;

@Data
@Entity
@Table(name="roles")

public class Role {
	 private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "ID")
	    private Integer id;
	    @Basic(optional = false)
	    @Column(name = "CODE")
	    private String code;
	    @Basic(optional = false)
	    @Column(name = "ROLE")
	    private String role;
	    @Basic(optional = false)
	    @Column(name = "LEVEL")
	    private int level;
	    

	    public Role() {
	    }
}
