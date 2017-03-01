package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.impl.PolicyServiceImpl;
import com.revature.controller.exception.InternalException;
import com.revature.model.Policy;

@RestController
@RequestMapping("/policy")
public class PolicyController {
	private static Logger logger = Logger.getLogger(PolicyController.class);

	@Autowired
	private PolicyServiceImpl policyService;

	@GetMapping("/")
	public List<Policy> getAllPolicyController() {
		List<Policy> policy = null;
		try {
			logger.info("Getting the Policy data...");
			policy = policyService.getAllPolicy();
			logger.info("Policy data retrieval success.");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return policy;
	}
}
