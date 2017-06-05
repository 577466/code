package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.dao.ViewEducationLoanDAO;
import com.cognizant.entity.EducationLoan;

@Component
public class ViewEducationLoanService {

	@Autowired
	ViewEducationLoanDAO dao;
	private List<EducationLoan> eduLoan = new ArrayList<EducationLoan>();

	public List<EducationLoan> retriveEducationLoanDetails(long i) {

		eduLoan = dao.retriveEducationLoanDetails(i);
		return eduLoan;
	}

}
