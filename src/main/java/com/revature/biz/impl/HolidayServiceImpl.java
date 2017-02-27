package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.exception.DataServiceException;
import com.revature.data.impl.HolidayDAOImpl;
import com.revature.model.Holiday;

@Service
public class HolidayServiceImpl {
	private static Logger logger = Logger.getLogger(HolidayServiceImpl.class);

	@Autowired
	private  HolidayDAOImpl holidayDAO;
	
	public List<Holiday> getAllHolidays() throws DataServiceException {
		List<Holiday> holiday=null;
		holiday=holidayDAO.getAllHolidays();
		logger.info("retrived successfully");
		return holiday;
	}
}
