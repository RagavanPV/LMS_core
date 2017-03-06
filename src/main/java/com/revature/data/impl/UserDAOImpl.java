package com.revature.data.impl;

import java.util.List;

import org.apache.commons.mail.EmailException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.ActivationUtil;
import com.revature.data.utils.MailUtil;
import com.revature.model.User;

@Repository
@Primary
public class UserDAOImpl{
	private static Logger logger = Logger.getLogger(UserDAOImpl.class);
	
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}
	
	public List<User> getAllUser() throws DataServiceException{
		
		StringBuilder stringBuilder=new StringBuilder("select u.id userid,u.employee_id employeeid,u.email_id useremail,e.name ename,e.role_id roleid from users u join employees e on u.employee_id=e.id");
		List<User> users = null;
		try {
			users = dataRetriver.retrieveListBySQL(stringBuilder.toString());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
	
		logger.info("Categories data retrieval success..");

		return users;
		
		
	}
	
	public List<User> getUser(String emailId,String password) throws DataServiceException{
		
		StringBuilder stringBuilder=new StringBuilder("SELECT u.id userid,e.gender gender,u.employee_id employeeid,u.email_id useremail,e.name username,e.role_id roleid,IFNULL((SELECT DISTINCT e.id FROM employees e JOIN employees m ON e.`ID`=m.manager_id JOIN users u ON u.`EMPLOYEE_ID`=e.`ID` WHERE email_id='"+emailId+"'),0) AS manager_id FROM users u JOIN employees e ON u.employee_id=e.id where email_id='"+emailId+"' and password='"+password+"'");
		List<User> users = null;
		try {
			users = dataRetriver.retrieveListBySQL(stringBuilder.toString());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
	
		logger.info("Categories data retrieval success..");

		return users;
		
		
	}
    public Integer forgotPassword(User user) throws DataServiceException, EmailException
    {
        String code=ActivationUtil.activateString();
        StringBuilder sb = new StringBuilder("update users u set activation_code='"+code+"' where u.email_id='"+user.getEmailId()+"'");
       Integer rows=null;
       try {
            rows=dataRetriver.update(sb.toString());
            user.setActivationCode(code);
        
            if(rows==1)
                {
                MailUtil.sendActivationMail(user);
                }
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return rows;
    }
	

}
