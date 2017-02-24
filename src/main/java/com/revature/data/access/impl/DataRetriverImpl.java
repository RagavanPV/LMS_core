package com.revature.data.access.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;

@Repository
@SuppressWarnings("unchecked")
public class DataRetriverImpl implements DataRetriver {

  private static Logger logger = Logger.getLogger(DataRetriverImpl.class);

  @Autowired
  private SessionFactory sessionFactory;


  public <E> List<E> retrieveByHQL(String queryString) throws DataAccessException {
    List<E> list = null;
    try {
      list = sessionFactory.getCurrentSession().createQuery(queryString).list();
      logger.info("data retrieval success..");
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      throw new DataAccessException(e.getMessage(), e);
    }
    return list;
  }

}
