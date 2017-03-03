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
import com.revature.model.Department;
import com.revature.model.LeavePolicy;
@Transactional
@Repository
public class LeavePolicyDAOImpl {
	private static Logger logger = Logger.getLogger(UserDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	public List<LeavePolicy> getAllLeavePolicy() throws DataServiceException{
		List<LeavePolicy> leavePolicy = null;
		try {
			StringBuilder sb = new StringBuilder("select * from leave_policy");
			leavePolicy = dataRetriver.retrieveListBySQL(sb.toString());
			logger.info("data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return leavePolicy;
	}
	public Integer add(LeavePolicy policy) throws DataServiceException {
		StringBuilder stringBuilder = new StringBuilder("insert into leave_policy(POLICY_ID,ROLE_ID,LEAVE_TYPE_ID,NO_OF_DAYS) values('"+policy.getPolicyId()+"','"+policy.getRoleId().getId()+"','"+policy.getLeaveTypeId().getId()+"','"+policy.getNoOfDays()+"')");
		
		Integer rows = null;
		try {
			rows = dataRetriver.add(stringBuilder.toString());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		logger.info("LeavePolicy data added");
		return rows;
	}
}
