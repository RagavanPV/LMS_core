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
import com.revature.data.utils.DataUtils;
import com.revature.model.Employee;
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
			        StringBuilder stringBuilder = new StringBuilder("SELECT LEAVE_DETAILS.ID AS ID,LEAVE_DETAILS.STATUS AS STATUS_ID,LEAVE_TYPES.NAME AS LEAVE_NAME, LEAVE_TYPE_ID ,DATE(APPLIED_DATE) AS DATEAPPLIED,MIN(DATE_OF_LEAVE) AS FROMDATE,MAX(DATE_OF_LEAVE) AS TODATE,REASON,LEAVE_STATUS.NAME AS STATUS,DENIED_REASON FROM LEAVE_DETAILS JOIN LEAVE_STATUS ON LEAVE_DETAILS.STATUS=LEAVE_STATUS.ID JOIN LEAVE_TYPES ON LEAVE_TYPES.ID=LEAVE_TYPE_ID WHERE EMPLOYEE_ID='"+l.getEmployeeId().getId()+"' GROUP BY APPLIED_DATE,EMPLOYEE_ID;");
			        List<LeaveDetail> leaveDetails = null;
			        try {
			            leaveDetails = dataRetriver.retrieveListBySQL(stringBuilder.toString());
			        } catch (DataAccessException e) {
			            e.printStackTrace();
			        }
			        logger.info("Department data retrieval success..");
			        return leaveDetails;
			    }
			    public List<LeaveDetail> getEmpLeaveByManagerId(Integer managerId) throws DataServiceException{
			        List<LeaveDetail> leaveDetails = null;
			        try {
			            StringBuilder sb = new StringBuilder("SELECT ld.ID,e.NAME AS EMP_NAME,r.NAME AS ROLE_NAME,e.GENDER,lt.NAME TYPE_NAME,MIN(DATE_OF_LEAVE) AS FROM_DATE,MAX(DATE_OF_LEAVE) AS TO_DATE,DATE(APPLIED_DATE) AS APPLIED_DATE,ld.REASON FROM `leave_details` ld JOIN employees e ON ld.`EMPLOYEE_ID`=e.`ID` JOIN leave_types lt ON lt.`ID`=ld.leave_type_id JOIN roles r ON r.`ID`=e.`ROLE_ID` WHERE STATUS=1 AND e.manager_id="+managerId+" GROUP BY APPLIED_DATE");
			            leaveDetails = dataRetriver.retrieveListBySQL(sb.toString());
			            logger.info("Categories data retrieval success..");
			        } catch (DataAccessException e) {
			            logger.error(e.getMessage(), e);
			            throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
			        }
			        return leaveDetails;
			}
			    
			    public int acceptLeave(Integer leaveId,Integer managerId) throws DataServiceException{
			    	int result;
			    	 try {
				            StringBuilder sb = new StringBuilder("UPDATE leave_details SET STATUS=3 , HANDLED_BY="+managerId+" WHERE APPLIED_DATE =(SELECT applied_date FROM (SELECT * FROM leave_details) AS ldsub WHERE ldsub.id="+leaveId+" )");
				            result= dataRetriver.update(sb.toString());
				            logger.info("Categories data retrieval success..");
				        } catch (DataAccessException e) {
				            logger.error(e.getMessage(), e);
				            throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
				        }
					return result;
			    	
			    }
			    public int rejectLeave(Integer leaveId,Integer managerId,String reason) throws DataServiceException{
			    	int result;
			    	 try {
				            StringBuilder sb = new StringBuilder("UPDATE leave_details SET STATUS=4 , HANDLED_BY="+managerId+",DENIED_REASON='"+reason+"' WHERE APPLIED_DATE =(SELECT applied_date FROM (SELECT * FROM leave_details) AS ldsub WHERE ldsub.id="+leaveId+" )");
				            result= dataRetriver.update(sb.toString());
				            logger.info("Categories data retrieval success..");
				        } catch (DataAccessException e) {
				            logger.error(e.getMessage(), e);
				            throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
				        }
					return result;
			    	
			    }
			    public int cancelLeave(Integer leaveId) throws DataServiceException{
			    	int result;
			    	 try {
				            StringBuilder sb = new StringBuilder("UPDATE leave_details SET STATUS=2 WHERE APPLIED_DATE =(SELECT applied_date FROM (SELECT * FROM leave_details) AS ldsub WHERE ldsub.id="+leaveId+" )");
				            result= dataRetriver.update(sb.toString());
				            logger.info("Categories data retrieval success..");
				        } catch (DataAccessException e) {
				            logger.error(e.getMessage(), e);
				            throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
				        }
					return result;
			    	
			    }
}
