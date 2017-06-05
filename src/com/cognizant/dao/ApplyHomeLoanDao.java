package com.cognizant.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.entity.UserDetails;

@Component
public class ApplyHomeLoanDao {

	private static final Logger LOG = Logger.getLogger(ApplyHomeLoanDao.class);

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void insertHomeDetails(UserDetails userDetails) {
		LOG.info(userDetails);
		em.persist(userDetails);
		LOG.info("after");

	}

	public UserDetails updateHomeLoanDetails(long l) {
		UserDetails retrive = em.find(UserDetails.class, l);
		LOG.info(retrive);
		return retrive;

	}

}
