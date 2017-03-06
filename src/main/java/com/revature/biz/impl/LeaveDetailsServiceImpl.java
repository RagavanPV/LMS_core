package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.exception.DataServiceException;
import com.revature.data.impl.LeaveDetailsDAOImpl;
import com.revature.model.LeaveDetail;

@Service
public class LeaveDetailsServiceImpl {
	private static Logger logger = Logger.getLogger(LeaveDetailsServiceImpl.class);

	@Autowired
	private LeaveDetailsDAOImpl daoImpl;

	public List<LeaveDetail> getAll() throws DataServiceException {
		List<LeaveDetail> leaveDetails = null;
		leaveDetails = daoImpl.getAll();
		logger.info("retrived successfully");
		return leaveDetails;
	}

	public List<LeaveDetail> getLeaveByEmployeeId(LeaveDetail l) throws DataServiceException {
		List<LeaveDetail> leaveDetails = null;
		leaveDetails = daoImpl.getLeaveByEmployeeId(l);
		logger.info("retrived successfully");
		return leaveDetails;
	}

	public List<LeaveDetail> getEmpLeaveListByManagerId(Integer managerId) throws DataServiceException {
		List<LeaveDetail> leaveDetail = daoImpl.getEmpLeaveByManagerId(managerId);
		logger.info("retrived successfully");
		return leaveDetail;
	}

	public int acceptLeave(Integer leaveId, Integer managerId) throws DataServiceException {
		int result = daoImpl.acceptLeave(leaveId, managerId);
		logger.info("retrived successfully");
		return result;
	}

	public int rejectLeave(Integer leaveId, Integer managerId, String reason) throws DataServiceException {
		int result = daoImpl.rejectLeave(leaveId, managerId, reason);
		logger.info("retrived successfully");
		return result;
	}

	public int cancelLeave(Integer leaveId) throws DataServiceException {
		int result = daoImpl.cancelLeave(leaveId);
		logger.info("retrived successfully");
		return result;
	}
}
