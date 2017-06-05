package com.cognizant.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.UserDetails;

@Component
public class ApplyEducationLoanDAO {

	private static final Logger LOG = Logger.getLogger(ApplyEducationLoanDAO.class);

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void insertEducationLoanDetails(UserDetails user) {
		// session.save() - em.persist()
		em.persist(user);
		LOG.info("in dao");

	}

	@Transactional
	public UserDetails updateEducationLoanDetails(long i) {
		// TODO Auto-generated method stub
		UserDetails user = em.find(UserDetails.class, i);
		LOG.info("after retrieval");
		LOG.info(user);

		return user;
	}

}
