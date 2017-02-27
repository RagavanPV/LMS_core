package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.impl.HolidayServiceImpl;
import com.revature.controller.exception.InternalException;
import com.revature.model.Holiday;

@RestController
@RequestMapping("/holiday")
public class HolidayController {

	private static Logger logger = Logger.getLogger(HolidayController.class);

	@Autowired
	private HolidayServiceImpl holidayService;
	/*@Autowired
	private UserDAOImpl user;*/

	@GetMapping("/")
	public List<Holiday> getAllHolidayController() {
		List<Holiday> holidays = null;
		try {
			logger.info("Getting the categories data...");
			holidays = holidayService.getAllHolidays();
			logger.info("categories data retrieval success.");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return holidays;
	}

}
