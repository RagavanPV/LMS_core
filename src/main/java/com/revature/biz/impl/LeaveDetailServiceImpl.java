package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.impl.LeaveDetailDAOImpl;
import com.revature.data.impl.LeavePolicyDAOImpl;
import com.revature.model.LeaveDetail;
import com.revature.model.LeavePolicy;

@Service
public class LeaveDetailServiceImpl {
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Autowired
	private LeaveDetailDAOImpl leaveDetailDAOImpl;
	
	public List<LeaveDetail> getAllLeaveDetails() throws BusinessServiceException {
		List<LeaveDetail> leaveDetails = null;
		try {
			leaveDetails = leaveDetailDAOImpl.getAllLeaveDetails();
			logger.info("Categories retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return leaveDetails;
	}
}
