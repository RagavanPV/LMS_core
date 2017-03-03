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
import com.revature.model.Department;
import com.revature.model.Holiday;
@Transactional
@Repository
public class HolidayDAOImpl {
	private static Logger logger = Logger.getLogger(UserDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	public List<Holiday> getAllHolidays() throws DataServiceException{
		List<Holiday> holidays = null;
		try {
			StringBuilder sb = new StringBuilder("SELECT ID,NAME,HOLIDAY_DATE,DAYNAME(HOLIDAY_DATE) AS DAY FROM HOLIDAYS");
			holidays = dataRetriver.retrieveListBySQL(sb.toString());
			logger.info("data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return holidays;
	}
	public Integer addHoliday(Holiday holiday) throws DataServiceException {
		StringBuilder stringBuilder = new StringBuilder("insert into holidays(NAME,HOLIDAY_DATE,HOLIDAY_YEAR) values('"+holiday.getName()+"','"+holiday.getHolidayDate()+"','"+holiday.getHolidayYear()+"')");
		
		Integer rows = null;
		try {
			rows = dataRetriver.add(stringBuilder.toString());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		logger.info("Holiday data added");
		return rows;
	}
}
