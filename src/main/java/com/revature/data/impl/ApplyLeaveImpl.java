package com.revature.data.impl;

import java.sql.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.dto.FullDayLeaveDTO;
import com.revature.dto.HalfDayLeaveDTO;

@Repository
public class ApplyLeaveImpl {
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
	
	public String callFullDayLeave(FullDayLeaveDTO leav) throws DataServiceException, DataAccessException {
		StringBuilder stringBuilder = new StringBuilder("PR_APPLY_FULLDAY_LEAVE");
		String result;
		result =  dataRetriver.fullDayLeave(stringBuilder.toString(),leav);
		logger.info("Success");
		return result;
	
	}

	public String callHalfDayLeave(HalfDayLeaveDTO leav) throws DataAccessException {
		StringBuilder stringBuilder = new StringBuilder("PR_APPLY_HALFDAY_LEAVE");
		String result;
		result =  dataRetriver.halfDayLeave(stringBuilder.toString(),leav);
		logger.info("Success");
		return result;
	}
}
