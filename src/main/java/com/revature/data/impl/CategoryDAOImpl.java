package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.CategoryDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
  private static Logger logger = Logger.getLogger(CategoryDAOImpl.class);
  @Autowired
  private DataRetriver dataRetriver;

  public DataRetriver getDataRetriver() {
    return dataRetriver;
  }


  public void setDataRetriver(DataRetriver dataRetriver) {
    this.dataRetriver = dataRetriver;
  }


  @Override
  public List<Category> getAllCategories() throws DataServiceException {
    List<Category> categories = null;
    try {
      StringBuilder sb = new StringBuilder("FROM Category c where c.isActive=true");
      categories = dataRetriver.retrieveByHQL(sb.toString());
      logger.info("Categories data retrieval success..");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
    }
    return categories;
  }

}
