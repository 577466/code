package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cognizant.dao.ViewHomeLoanDao;
import com.cognizant.entity.HomeLoan;

@Component
public class ViewHomeLoanService {

	@Autowired
	ViewHomeLoanDao viewHomeLoanDao;

	private List<HomeLoan> homeLoan = new ArrayList<HomeLoan>();

	public List<HomeLoan> retrieveHomeDetails(long l) {

		homeLoan = viewHomeLoanDao.retrieveHomeDetails(l);
		return homeLoan;
	}

}
