package com.revature.data.access.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
@Transactional
@Repository
@SuppressWarnings("unchecked")
public class DataRetriverImpl implements DataRetriver {

	private static Logger logger = Logger.getLogger(DataRetriverImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	

	public <E> List<E> retrieveListBySQL(String queryString) throws DataAccessException {
		List<E> list = null;
		try {
			list = sessionFactory.getCurrentSession().createSQLQuery(queryString).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
			logger.info("data retrieval success..");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new DataAccessException(e.getMessage(), e);
		}
		return list;
	}
	public <E> Object retrieveOneBySQL(String queryString) throws DataAccessException {
		Object list = null;
		try {
			list = sessionFactory.getCurrentSession().createSQLQuery(queryString).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).uniqueResult();
			logger.info("data retrieval success..");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new DataAccessException(e.getMessage(), e);
		}
		return list;
	}
	

}