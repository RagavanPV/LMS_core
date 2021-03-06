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
import com.revature.model.Employee;
@Transactional
@Repository
public class EmployeeDAOImpl {
	private static Logger logger = Logger.getLogger(UserDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	public List<Employee> getAllEmployees() throws DataServiceException{
		List<Employee> employees = null;
		try {
			StringBuilder sb = new StringBuilder("SELECT e.id,e.name AS name,e.joining_date,r.name AS roleName,m.name AS managerName,d.name AS deptName FROM employees e JOIN roles r ON r.`ID`=e.`ROLE_ID` LEFT JOIN employees m ON e.manager_id=m.id JOIN departments d ON e.department_id=d.id;");
			employees = dataRetriver.retrieveListBySQL(sb.toString());
			logger.info("Categories data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return employees;
	}
	public List<Employee> getEmpByManagerId(Integer managerId) throws DataServiceException{
        List<Employee> employees = null;
        try {
            StringBuilder sb = new StringBuilder("SELECT EMPLOYEES.ID,EMPLOYEES.NAME EMP_NAME ,ROLES.NAME ROLE,DEPARTMENTS.NAME DEPT_NAME FROM EMPLOYEES JOIN DEPARTMENTS JOIN ROLES "
+"ON EMPLOYEES.ROLE_ID=ROLES.ID AND EMPLOYEES.DEPARTMENT_ID=DEPARTMENTS.ID WHERE EMPLOYEES.MANAGER_ID='"+managerId+"'");
            employees = dataRetriver.retrieveListBySQL(sb.toString());
            logger.info("Categories data retrieval success..");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
        }
        return employees;
}
	public List<Employee> getEmpById(Integer empId) throws DataServiceException{
        List<Employee> employees = null;
        try {
            StringBuilder sb = new StringBuilder("SELECT EMPLOYEES.ID,EMPLOYEES.NAME EMP_NAME ,ROLES.NAME ROLE,DEPARTMENTS.NAME DEPT_NAME FROM EMPLOYEES JOIN DEPARTMENTS JOIN ROLES "
+"ON EMPLOYEES.ROLE_ID=ROLES.ID AND EMPLOYEES.DEPARTMENT_ID=DEPARTMENTS.ID WHERE EMPLOYEES.ID='"+empId+"'");
            employees = dataRetriver.retrieveListBySQL(sb.toString());
            logger.info("Categories data retrieval success..");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
        }
        return employees;
}
	public Integer releaveEmployee(Employee employee) throws DataServiceException {
				StringBuilder stringBuilder = new StringBuilder("update employees set releaving_date='"+employee.getReleaving()+"',releaving_reason='"+employee.getReleavingReason()+"' where id='"+employee.getId()+"'");
				
				Integer rows = null;
				try {
					rows = dataRetriver.update(stringBuilder.toString());
				} catch (DataAccessException e) {
					e.printStackTrace();
				}
				logger.info("Employee Releaved");
				return rows;
			}
	public Integer updateRoleForEmployee(Employee employee) throws DataServiceException {
				StringBuilder stringBuilder = new StringBuilder("update employees set role_id='"+employee.getRoleId().getId()+"' where id='"+employee.getId()+"'");
				
				Integer rows = null;
				try {
					rows = dataRetriver.update(stringBuilder.toString());
				} catch (DataAccessException e) {
					e.printStackTrace();
				}
				logger.info("Employee data added");
				return rows;
			}
	public Integer updateDeptForEmployee(Employee employee) throws DataServiceException {
        StringBuilder stringBuilder = new StringBuilder("update employees set department_id='" + employee.getDepartmentId().getId()+ "' where id='" + employee.getId() + "'");
        Integer rows = null;
        try {
            rows = dataRetriver.update(stringBuilder.toString());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        logger.info("Employee data added");
        return rows;
    }
	public List<Employee> getRemainingLeave(Employee employee) throws DataServiceException{
        List<Employee> employees = null;
        List<Employee> emp=null;
        
        try {
            StringBuilder sb = new StringBuilder("select FN_GET_EMPLOYEE_LEAVES('"+employee.getId()+"')AS LEAVE_LEFT");
            employees = dataRetriver.retrieveListBySQL(sb.toString());
            logger.info("Categories data retrieval success..");
        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
        }
        return employees;
    }
}
