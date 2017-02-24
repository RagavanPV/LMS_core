package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.CategoryService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.Category;

@RestController
@RequestMapping("/")
public class CategoryController {

	private static Logger logger = Logger.getLogger(CategoryController.class);

	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/categories")
	public List<Category> getActiveCategoriesController() {
		List<Category> categories = null;
		try {
			logger.info("Getting the categories data...");
			categories = categoryService.getAllCategories();
			logger.info("categories data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return categories;
	}
}
