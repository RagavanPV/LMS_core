package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.impl.LeavePolicyServiceImpl;
import com.revature.controller.exception.InternalException;
import com.revature.data.exception.DataServiceException;
import com.revature.model.LeavePolicy;
import com.revature.model.LeaveType;
import com.revature.model.Policy;
import com.revature.model.Role;

@RestController
@RequestMapping("/leavepolicy")
public class LeavePolicyController {
	private static Logger logger = Logger.getLogger(LeavePolicyController.class);

	@Autowired
	private LeavePolicyServiceImpl leavePolicyService;

	@GetMapping("/")
	public List<LeavePolicy> getAllLeavePolicyController() {
		List<LeavePolicy> leavePolicy = null;
		try {
			logger.info("Getting the Leave Policy data...");
			leavePolicy = leavePolicyService.getAllLeavePolicy();
			logger.info("Leave Policy data retrieval success.");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return leavePolicy;
	}

	@PostMapping("/update")
	public Integer updateLeavePolicy(@RequestBody LeavePolicy l) {
		try {
			LeavePolicy policy = new LeavePolicy();
			Policy p = new Policy();
			p.setId(policy.getPolicyId().getId());
			Role r = new Role();
			r.setId(policy.getRoleId().getId());
			LeaveType lt = new LeaveType();
			lt.setId(policy.getLeaveTypeId().getId());
			policy.setNoOfDays(l.getNoOfDays());
			return leavePolicyService.updateLeavePolicy(policy);
		} catch (DataServiceException e) {
			e.printStackTrace();
		}
		return null;
	}
}
