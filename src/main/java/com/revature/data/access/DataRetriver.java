package com.revature.data.access;

import java.util.List;

import com.revature.data.access.exception.DataAccessException;
import com.revature.dto.FullDayLeaveDTO;
import com.revature.dto.HalfDayLeaveDTO;

public interface DataRetriver {
	/**
	 * Used to get the data by hql query.
	 * 
	 * @param query
	 *            query to execute
	 * @return the requested data
	 * @throws DataAccessException
	 *             if query format error
	 */
	public <E> List<E> retrieveListBySQL(String query) throws DataAccessException;

	public <E> Object retrieveOneBySQL(String query) throws DataAccessException;

	public <E> Integer add(String query) throws DataAccessException;

	public <E> Integer update(String query) throws DataAccessException;

	public <E> String halfDayLeave(String string, HalfDayLeaveDTO leave) throws DataAccessException;

	public <E> String fullDayLeave(String query, FullDayLeaveDTO leave) throws DataAccessException;

}
