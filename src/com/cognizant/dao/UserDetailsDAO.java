package com.cognizant.dao;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.entity.UserDetails;

@Component
public class UserDetailsDAO {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void addUser(UserDetails u) {
		em.persist(u);

	}

}
