package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.exception.DataServiceException;
import com.revature.data.impl.LeaveStatusDAOImpl;
import com.revature.model.LeaveStatus;

@Service
public class LeaveStatusServiceImpl {
	private static Logger logger = Logger.getLogger(LeaveStatusServiceImpl.class);

	@Autowired
	private  LeaveStatusDAOImpl leaveStatusDAO;
	
	public List<LeaveStatus> list() throws DataServiceException {
		List<LeaveStatus> leaveStatus=null;
		leaveStatus=leaveStatusDAO.getAllLeaveStatus();
		logger.info("retrived successfully");
		return leaveStatus;
	}
}
