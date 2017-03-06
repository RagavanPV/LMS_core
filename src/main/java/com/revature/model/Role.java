package com.revature.model;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	    @Column(name = "NAME")
	    private String role;
	    @Basic(optional = false)
	    @Column(name = "LEVEL")
	    private int level;
	    

	    public Role() {
	    }
}
