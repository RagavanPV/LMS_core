package com.revature.data.access.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.dto.UserDTO;
import com.revature.model.Department;
import com.revature.model.Employee;
import com.revature.model.Role;
import com.revature.model.User;

@Repository
@SuppressWarnings("unchecked")
public class DataRetriverImpl implements DataRetriver {

	private static Logger logger = Logger.getLogger(DataRetriverImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	

	public <E> List<E> retrieveBySQL(String queryString) throws DataAccessException {
		List<E> list = null;
		try {
			list = sessionFactory.getCurrentSession().createSQLQuery(queryString).list();
			logger.info("data retrieval success..");
		} catch (Exception e) {
			System.out.println("Retreiver exception");
			logger.error(e.getMessage(), e);
			throw new DataAccessException(e.getMessage(), e);
		}
		return list;
	}
	

}