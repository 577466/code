package com.cognizant.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.entity.HomeLoan;
import com.cognizant.entity.UserDetails;

@Component
public class ViewHomeLoanDao {

	private static final Logger LOG = Logger.getLogger(ViewHomeLoanDao.class);

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public List<HomeLoan> retrieveHomeDetails(long l) {

		UserDetails retrive = em.find(UserDetails.class, l);
		LOG.info(retrive);
		LOG.info(retrive.getHomeLoan());

		return retrive.getHomeLoan();
	}

}
