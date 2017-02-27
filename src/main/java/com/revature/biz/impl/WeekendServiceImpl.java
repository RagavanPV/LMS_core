package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.exception.DataServiceException;
import com.revature.data.impl.WeekendDAOImpl;
import com.revature.model.Weekend;

@Service
public class WeekendServiceImpl {
	private static Logger logger = Logger.getLogger(WeekendServiceImpl.class);

	@Autowired
	private  WeekendDAOImpl weekendDAO;
	
	public List<Weekend> list() throws DataServiceException {
		List<Weekend> weekend=null;
		weekend=weekendDAO.getAllWeekends();
		logger.info("retrived successfully");
		return weekend;
	}
}
