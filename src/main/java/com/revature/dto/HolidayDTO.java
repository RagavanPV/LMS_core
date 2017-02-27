package com.revature.dto;

import java.util.Date;

import lombok.Data;

@Data
public class HolidayDTO {
	private Integer id;
	private String name;
	private Date holidayDate;
	private Date holidayYear;

}
