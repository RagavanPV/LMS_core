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
			StringBuilder sb = new StringBuilder("SELECT lp.id,p.name AS policy_name,p.policy_year,r.NAME AS role_name,lt.NAME AS type_name,no_of_days FROM leave_policy lp JOIN policies p ON lp.policy_id=p.id JOIN roles r ON lp.role_id=r.id JOIN leave_types lt ON lp.leave_type_id=lt.id");
			leavePolicy = dataRetriver.retrieveListBySQL(sb.toString());
			logger.info("data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return leavePolicy;
	}
	public Integer updateLeavePolicy(LeavePolicy policy) throws DataServiceException {
				StringBuilder stringBuilder = new StringBuilder("update leave_policy set policy_id='"+policy.getPolicyId().getId()+"',role_id='"+policy.getRoleId().getId()+"',leave_type_id='"+policy.getLeaveTypeId().getId()+"',no_of_days='"+policy.getNoOfDays()+"' where id='"+policy.getId()+"");
				
				Integer rows = null;
				try {
					rows = dataRetriver.update(stringBuilder.toString());
				} catch (DataAccessException e) {
					e.printStackTrace();
				}
				logger.info("LeavePolicy data added");
				return rows;
			}
}
