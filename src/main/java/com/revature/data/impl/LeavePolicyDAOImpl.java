package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.LeavePolicy;
import com.revature.model.LeaveStatus;
@Repository
public class LeavePolicyDAOImpl {
	private static Logger logger = Logger.getLogger(LeavePolicyDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}
	
	public List<LeavePolicy> getAllLeavePolicies() throws DataServiceException {
		List<LeavePolicy> leavePolicy = null;
		try {
			StringBuilder sb = new StringBuilder("Select * from leave_policy");
			leavePolicy = dataRetriver.retrieveByHQL(sb.toString());
			logger.info("Users data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return leavePolicy;
	}
}
