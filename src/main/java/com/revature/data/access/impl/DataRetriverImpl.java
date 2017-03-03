package com.revature.data.access.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.aspectj.apache.bcel.generic.Type;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.ProcedureOutputs;
import org.hibernate.result.ResultSetOutput;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.model.Department;
@Transactional
@Repository
@SuppressWarnings("unchecked")
public class DataRetriverImpl implements DataRetriver {

	private static Logger logger = Logger.getLogger(DataRetriverImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private EntityManager em;
	

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
	public <E> Integer add(String queryString) throws DataAccessException {
		int rows;
		try {
			rows = sessionFactory.getCurrentSession().createSQLQuery(queryString).executeUpdate();
			logger.info("data retrieval success..");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new DataAccessException(e.getMessage(), e);
		}
		return rows;
	}
	public <E> String callProcedure(String queryString,Department department) throws DataAccessException {
		String e;
		try {
			sessionFactory.getCurrentSession();
			
			StoredProcedureQuery q=em.createStoredProcedureQuery(queryString).registerStoredProcedureParameter("i_depcode",String.class,ParameterMode.IN).setParameter("i_depcode",department.getCode())
					.registerStoredProcedureParameter("i_depname",String.class,ParameterMode.IN).setParameter("i_depname",department.getName()).registerStoredProcedureParameter("errmsg",String.class,ParameterMode.OUT);
			q.execute();
		  e=(String) q.getOutputParameterValue("errmsg");
	
			
			logger.info("data retrieval success..");
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new DataAccessException(ex.getMessage(), ex);
		}
		return e;
	}
	
	public <E> Integer update(String queryString) throws DataAccessException {
		int rows;
		try {
			rows = sessionFactory.getCurrentSession().createSQLQuery(queryString).executeUpdate();
			logger.info("data retrieval success..");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new DataAccessException(e.getMessage(), e);
		}
		return rows;
	}
	
	
}