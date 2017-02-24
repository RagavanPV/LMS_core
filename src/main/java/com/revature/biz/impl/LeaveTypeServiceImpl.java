package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.impl.LeaveTypeDAOImpl;
import com.revature.data.impl.PolicyDAOImpl;
import com.revature.model.LeaveType;
import com.revature.model.Policy;

@Service
public class LeaveTypeServiceImpl {
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Autowired
	private LeaveTypeDAOImpl leaveTypeDAOImpl;
	
	public List<LeaveType> getAllLeaveTypes() throws BusinessServiceException {
		List<LeaveType> leaveTypes = null;
		try {
			leaveTypes = leaveTypeDAOImpl.getAllLeaveTypes();
			logger.info("Categories retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return leaveTypes;
	}
}
