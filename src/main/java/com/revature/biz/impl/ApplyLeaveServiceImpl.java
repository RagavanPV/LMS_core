package com.revature.biz.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.impl.ApplyLeaveImpl;
import com.revature.dto.FullDayLeaveDTO;
import com.revature.dto.HalfDayLeaveDTO;

@Service
public class ApplyLeaveServiceImpl {
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	ApplyLeaveImpl applyLeav;

	public String applyFullDayLeave(FullDayLeaveDTO leav) throws DataServiceException, DataAccessException {
		String result;
		result = applyLeav.callFullDayLeave(leav);
		logger.info("retrived successfully");
		return result;
	}

	public String applyHalfDayLeave(HalfDayLeaveDTO leav) throws DataAccessException {
		String result;
		result = applyLeav.callHalfDayLeave(leav);
		logger.info("retrived successfully");
		return result;
	}
}
