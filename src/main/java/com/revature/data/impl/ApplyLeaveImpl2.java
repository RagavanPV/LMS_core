package com.revature.data.impl;

import java.sql.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;

@Repository
public class ApplyLeaveImpl2 {
	private static Logger logger = Logger.getLogger(UserDAOImpl.class);

	@Autowired
	private DataRetriver dataRetriver;

	final ObjectMapper mapper = new ObjectMapper();

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}
	
	public Integer callFullDayLeave(int empId,int leaveId,Date fromDate, Date toDate,String reason) throws DataServiceException, DataAccessException {
		StringBuilder stringBuilder = new StringBuilder("call PR_APPLY_FULLDAY_LEAVE_V2('"+empId+"','"+leaveId+"','"+fromDate+"','"+toDate+"','"+reason+"')");
		Integer result;
		result =  dataRetriver.procedureCall(stringBuilder.toString());
		logger.info("Success");
		return result;
	
	}
}

