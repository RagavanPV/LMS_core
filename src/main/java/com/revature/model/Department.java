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
@Table(name="departments",catalog="lms-app")
public class Department {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Integer id;
@Column(name="CODE")
private String code;
@Column(name="NAME")
private String name;
}
