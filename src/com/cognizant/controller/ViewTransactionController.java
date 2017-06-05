package com.cognizant.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.entity.TransactionDetails;
import com.cognizant.service.PerformTransactionService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;

@Controller
public class ViewTransactionController {
	@Autowired
	PerformTransactionService service;
	TransactionDetails transactionDetails;

	private static final Logger LOG = Logger.getLogger(ViewTransactionController.class);

	@RequestMapping(value = "/getTransaction", method = RequestMethod.GET)
	public String searchUserTransaction() {

		return "getTransaction";
	}

	@RequestMapping(value = "/getTransactionDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody List<TransactionDetails> getUserDetails() {

		List<TransactionDetails> transactionDetailsList = service.retrieveTransactionDetails(1234567890123546L);

		LOG.info("controller:" + transactionDetailsList);
		return transactionDetailsList;

	}

}
