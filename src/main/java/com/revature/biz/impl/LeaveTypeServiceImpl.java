package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.exception.DataServiceException;
import com.revature.data.impl.LeaveTypeDAOImpl;
import com.revature.model.LeaveType;

@Service
public class LeaveTypeServiceImpl {
	private static Logger logger = Logger.getLogger(LeaveTypeServiceImpl.class);

	@Autowired
	private  LeaveTypeDAOImpl leaveTypeDAO;
	
	public List<LeaveType> list() throws DataServiceException {
		List<LeaveType> leaveType=null;
		leaveType=leaveTypeDAO.getAllLeaveTypes();
		logger.info("retrived successfully");
		return leaveType;
	}
}
