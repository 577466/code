package com.cognizant.controller;

import java.util.ArrayList;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cognizant.entity.HomeLoan;
import com.cognizant.service.ViewHomeLoanService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;

@Controller
public class ViewHomeLoanController {

	@Autowired
	ViewHomeLoanService viewHomeLoanService;
	private List<HomeLoan> homeLoans = new ArrayList<HomeLoan>();

	private static final Logger LOG = Logger.getLogger(ViewHomeLoanController.class);

	@RequestMapping(value = "/viewHomeLoan", method = RequestMethod.GET)
	public String getHOmeLoan() {

		return "viewHomeLoan";
	}

	@RequestMapping(value = "/viewHomeLoan1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<HomeLoan> gethomeLoan() {
		homeLoans = viewHomeLoanService.retrieveHomeDetails(1234567890123546L);

		LOG.info("in control");

		LOG.info(homeLoans);

		return homeLoans;

	}

}
