package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.impl.PolicyDAOImpl;
import com.revature.data.impl.UserDAOImpl;
import com.revature.model.Policy;
import com.revature.model.User;

@Service
public class PolicyServiceImpl {
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Autowired
	private PolicyDAOImpl policyDAOImpl;
	
	public List<Policy> getAllPolicies() throws BusinessServiceException {
		List<Policy> policies = null;
		try {
			policies = policyDAOImpl.getAllPolicies();
			logger.info("Categories retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return policies;
	}
}
