package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.CategoryService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.CategoryDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

  private static Logger logger = Logger.getLogger(CategoryServiceImpl.class);

  @Autowired
  private CategoryDAO categoryDAO;

  @Override
  public List<Category> getAllCategories() throws BusinessServiceException {
    List<Category> categories = null;
    try {
      categories = categoryDAO.getAllCategories();
      logger.info("Categories retrieved successfully");
    } catch (DataServiceException e) {
      logger.error(e.getMessage(), e);
      throw new BusinessServiceException(e.getMessage(), e);
    }
    return categories;
  }

}
