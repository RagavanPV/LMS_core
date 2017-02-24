package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.Category;

public interface CategoryDAO {

  /**
   * Used to get the categories data from db.
   * 
   * @return categories
   * @throws DataServiceException if any exception happens while executing the query
   */

  public List<Category> getAllCategories() throws DataServiceException;

}
