package com.revature.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name="holidays",catalog="lms-app")
public class Holiday {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Integer id;
@Column(name="NAME")
private String name;

@Column(name="HOLIDAY_DATE")
@Temporal(TemporalType.DATE)
private Date holidayDate;
@Column(name="HOLIDAY_YEAR")
@Temporal(TemporalType.DATE)

private Date holidayYear;

}
