package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.model.LeaveDetail;

@Repository
@Primary
public class LeaveDetailsDAOImpl {
			private static Logger logger = Logger.getLogger(LeaveDetailsDAOImpl.class);
			    @Autowired
			    private DataRetriver dataRetriver;

			    final ObjectMapper mapper = new ObjectMapper();

			    public DataRetriver getDataRetriver() {
			        return dataRetriver;
			    }

			    public void setDataRetriver(DataRetriver dataRetriver) {
			        this.dataRetriver = dataRetriver;
			    }
			    public List<LeaveDetail> getAll() throws DataServiceException {
			        StringBuilder stringBuilder = new StringBuilder("select * from leave_details");
			        List<LeaveDetail> leaveDetails = null;
			        try {
			            leaveDetails = dataRetriver.retrieveListBySQL(stringBuilder.toString());
			        } catch (DataAccessException e) {
			            e.printStackTrace();
			        }
			        logger.info("Department data retrieval success..");
			        return leaveDetails;
			    }
			    public List<LeaveDetail> getLeaveByEmployeeId(LeaveDetail l) throws DataServiceException {
			        StringBuilder stringBuilder = new StringBuilder("SELECT LEAVE_TYPES.NAME AS LEAVE_NAME, LEAVE_TYPE_ID ,DATE(APPLIED_DATE) AS DATEAPPLIED,MIN(DATE_OF_LEAVE) AS FROMDATE,MAX(DATE_OF_LEAVE) AS TODATE,REASON,LEAVE_STATUS.NAME AS STATUS,DENIED_REASON FROM LEAVE_DETAILS JOIN LEAVE_STATUS ON LEAVE_DETAILS.STATUS=LEAVE_STATUS.ID JOIN LEAVE_TYPES ON LEAVE_TYPES.ID=LEAVE_TYPE_ID WHERE EMPLOYEE_ID='"+l.getEmployeeId().getId()+"' GROUP BY APPLIED_DATE,EMPLOYEE_ID;");
			        List<LeaveDetail> leaveDetails = null;
			        try {
			            leaveDetails = dataRetriver.retrieveListBySQL(stringBuilder.toString());
			        } catch (DataAccessException e) {
			            e.printStackTrace();
			        }
			        logger.info("Department data retrieval success..");
			        return leaveDetails;
			    }
}
