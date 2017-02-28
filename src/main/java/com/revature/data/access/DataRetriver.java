package com.revature.data.access;

import java.util.List;

import com.revature.data.access.exception.DataAccessException;
import com.revature.model.User;

public interface DataRetriver {
  /**
   * Used to get the data by hql query.
   * 
   * @param query query to execute
   * @return the requested data
   * @throws DataAccessException if query format error
   */
  public <E> List<E> retrieveBySQL(String query) throws DataAccessException;

}
