package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.exception.DataServiceException;
import com.revature.data.impl.LeavePolicyDAOImpl;
import com.revature.model.LeavePolicy;

@Service
public class LeavePolicyServiceImpl {
	private static Logger logger = Logger.getLogger(LeavePolicyServiceImpl.class);

	@Autowired
	private LeavePolicyDAOImpl leavePolicyDAO;

	public List<LeavePolicy> getAllLeavePolicy() throws DataServiceException {
		List<LeavePolicy> leavePolicy = null;
		leavePolicy = leavePolicyDAO.getAllLeavePolicy();
		logger.info("retrived successfully");
		return leavePolicy;
	}

	public Integer updateLeavePolicy(LeavePolicy policy) throws DataServiceException {
		int rows = leavePolicyDAO.updateLeavePolicy(policy);
		logger.info("updated policy details.");
		return rows;
	}
	 public Integer updateNoOfDays(LeavePolicy leavePolicy) throws DataServiceException {
	        int rows = leavePolicyDAO.updateNoOfDays(leavePolicy);
	                
	        logger.info("Updated Role for employee");
	        return rows;
	    }
}
