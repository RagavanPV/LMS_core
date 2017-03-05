package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.LeaveType;
import com.revature.model.Role;
@Transactional
@Repository
public class LeaveTypeDAOImpl {
	private static Logger logger = Logger.getLogger(UserDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	public List<LeaveType> getAllLeaveTypes() throws DataServiceException{
		List<LeaveType> leaveType = null;
		try {
			StringBuilder sb = new StringBuilder("select * from leave_types");
			leaveType = dataRetriver.retrieveListBySQL(sb.toString());
			logger.info("data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return leaveType;
	}
	public Integer add(LeaveType lt) throws DataServiceException {
		StringBuilder stringBuilder = new StringBuilder("insert into leave_types(CODE,NAME) values('"+lt.getCode()+"','"+lt.getName()+"')");
		
		Integer rows = null;
		try {
			rows = dataRetriver.add(stringBuilder.toString());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		logger.info("Department data retrieval success..");
		return rows;
	}
	public List<LeaveType> getLeaveM() throws DataServiceException{
		List<LeaveType> leaveType = null;
		try {
			StringBuilder sb = new StringBuilder("select * from leave_types l where l.CODE!='MATERNITY'");
			leaveType = dataRetriver.retrieveListBySQL(sb.toString());
			logger.info("data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return leaveType;
	}
	public List<LeaveType> getLeaveF() throws DataServiceException{
		List<LeaveType> leaveType = null;
		try {
			StringBuilder sb = new StringBuilder("select * from leave_types l where l.CODE!='PATERNITY'");
			leaveType = dataRetriver.retrieveListBySQL(sb.toString());
			logger.info("data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return leaveType;
	}
	public Integer update(LeaveType lt) throws DataServiceException {
		StringBuilder stringBuilder = new StringBuilder("update leave_types set name='"+lt.getName()+"',code='"+lt.getCode()+"' where id='"+lt.getId()+"");
		
		Integer rows = null;
		try {
			rows = dataRetriver.update(stringBuilder.toString());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		logger.info("Department data retrieval success..");
		return rows;
	}
}
