package com.cognizant.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.EducationLoan;
import com.cognizant.entity.UserDetails;

@Component
public class ViewEducationLoanDAO {

	private static final Logger LOG = Logger.getLogger(ViewEducationLoanDAO.class);

	@PersistenceContext
	EntityManager em;

	@Transactional
	public List<EducationLoan> retriveEducationLoanDetails(long i) {
		// TODO Auto-generated method stub
		LOG.info("in dao");
		UserDetails retrive = em.find(UserDetails.class, i);
		LOG.info("after retrieval");
		LOG.info(retrive);
		LOG.info(retrive.getEduLoan());

		return retrive.getEduLoan();

	}
}
