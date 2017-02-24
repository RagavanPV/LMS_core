package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.impl.LeaveStatusDAOImpl;
import com.revature.data.impl.LeaveTypeDAOImpl;
import com.revature.model.LeaveStatus;
import com.revature.model.LeaveType;

@Service
public class LeaveStatusServiceImpl {
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Autowired
	private LeaveStatusDAOImpl leaveStatusDAOImpl;
	
	public List<LeaveStatus> getAllLeaveStatus() throws BusinessServiceException {
		List<LeaveStatus> leaveStatus = null;
		try {
			leaveStatus = leaveStatusDAOImpl.getAllLeaveStatus();
			logger.info("Categories retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return leaveStatus;
	}
}
