package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.impl.LeavePolicyDAOImpl;
import com.revature.data.impl.LeaveStatusDAOImpl;
import com.revature.model.LeavePolicy;
import com.revature.model.LeaveStatus;

@Service
public class LeavePolicyServiceImpl {
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Autowired
	private LeavePolicyDAOImpl leavePolicyDAOImpl;
	
	public List<LeavePolicy> getAllLeaveStatus() throws BusinessServiceException {
		List<LeavePolicy> leavepolicies = null;
		try {
			leavepolicies = leavePolicyDAOImpl.getAllLeavePolicies();
			logger.info("Categories retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return leavepolicies;
	}
}
