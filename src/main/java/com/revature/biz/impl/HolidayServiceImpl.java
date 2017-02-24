package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.impl.HolidayDAOImpl;
import com.revature.data.impl.LeaveDetailDAOImpl;
import com.revature.model.Holiday;
import com.revature.model.LeaveDetail;

@Service
public class HolidayServiceImpl {
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Autowired
	private HolidayDAOImpl holidayDAOImpl;
	
	public List<Holiday> getAllHolidays() throws BusinessServiceException {
		List<Holiday> holidays = null;
		try {
			holidays = holidayDAOImpl.getAllHolidays();
			logger.info("Categories retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return holidays;
	}
}
