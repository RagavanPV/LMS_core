package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.exception.DataServiceException;
import com.revature.data.impl.PolicyDAOImpl;
import com.revature.model.Policy;

@Service
public class PolicyServiceImpl {
	private static Logger logger = Logger.getLogger(PolicyServiceImpl.class);

	@Autowired
	private  PolicyDAOImpl policyDAO;
	
	public List<Policy> list() throws DataServiceException {
		List<Policy> policy=null;
		policy=policyDAO.getAllPolicy();
		logger.info("retrived successfully");
		return policy;
	}
}
