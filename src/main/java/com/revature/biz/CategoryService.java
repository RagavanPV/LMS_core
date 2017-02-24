package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.Category;

public interface CategoryService {

  /**
   * Used to get all the categories.
   * 
   * @return categories
   * @throws BusinessServiceException if any business error occurs
   */
  List<Category> getAllCategories() throws BusinessServiceException;


}
