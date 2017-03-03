package com.revature.data.access.impl;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.dto.FullDayLeaveDTO;
import com.revature.dto.HalfDayLeaveDTO;
@Transactional
@Repository
@SuppressWarnings("unchecked")
public class DataRetriverImpl implements DataRetriver {

	private static Logger logger = Logger.getLogger(DataRetriverImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private EntityManager entityManager;

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
	public Integer procedureCall(String queryString) throws DataAccessException {
		int result;
		try {
			
			result=sessionFactory.getCurrentSession().createSQLQuery(queryString).executeUpdate();
			logger.info("data retrieval success..");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new DataAccessException(e.getMessage(), e);
		}
		return result;
	
	}
	
	public <E> String fullDayLeave(String query,FullDayLeaveDTO leave)
			throws DataAccessException {

		String errmsg = null;

		try {

			sessionFactory.getCurrentSession();

			StoredProcedureQuery q = entityManager.createStoredProcedureQuery(query)
					.registerStoredProcedureParameter("i_employee_id", Integer.class, ParameterMode.IN)
					.setParameter("i_employee_id", leave.getEmpDTO().getId())

					.registerStoredProcedureParameter("i_leave_id", Integer.class, ParameterMode.IN)
					.setParameter("i_leave_id", leave.getLeavDTO().getId())
					
					.registerStoredProcedureParameter("i_from_date", Date.class, ParameterMode.IN)
					.setParameter("i_from_date", leave.getFromDate())
					
					.registerStoredProcedureParameter("i_to_date", Date.class, ParameterMode.IN)
					.setParameter("i_to_date", leave.getToDate())
					
					.registerStoredProcedureParameter("i_reason", String.class, ParameterMode.IN)
					.setParameter("i_reason", leave.getReason())
					
					.registerStoredProcedureParameter("result", String.class, ParameterMode.OUT);

			q.execute();

			errmsg = (String) q.getOutputParameterValue("result");
			System.out.println(leave+"test");
			System.out.println(errmsg);

			logger.info("data retrieval success..");

		} catch (Exception e) {

			logger.error(e.getMessage(), e);

			throw new DataAccessException(e.getMessage(), e);

		}

		return errmsg;

	}
	@Override
	public <E> String halfDayLeave(String string, HalfDayLeaveDTO leave) throws DataAccessException {
		String errmsg = null;

		try {

			sessionFactory.getCurrentSession();

			StoredProcedureQuery q = entityManager.createStoredProcedureQuery(string)
					.registerStoredProcedureParameter("i_employee_id", Integer.class, ParameterMode.IN)
					.setParameter("i_employee_id", leave.getEmpDTO().getId())

					.registerStoredProcedureParameter("i_leave_id", Integer.class, ParameterMode.IN)
					.setParameter("i_leave_id", leave.getLeavDTO().getId())
					
					.registerStoredProcedureParameter("i_leave_date", Date.class, ParameterMode.IN)
					.setParameter("i_leave_date", leave.getFromDate())
					
					.registerStoredProcedureParameter("i_session", Character.class, ParameterMode.IN)
					.setParameter("i_session", leave.getSession())
					
					.registerStoredProcedureParameter("i_reason", String.class, ParameterMode.IN)
					.setParameter("i_reason", leave.getReason())
					
					.registerStoredProcedureParameter("result", String.class, ParameterMode.OUT);

			q.execute();

			errmsg = (String) q.getOutputParameterValue("result");

			System.out.println(errmsg);

			logger.info("data retrieval success..");

		} catch (Exception e) {

			logger.error(e.getMessage(), e);

			throw new DataAccessException(e.getMessage(), e);

		}

		return errmsg;
	}
}
