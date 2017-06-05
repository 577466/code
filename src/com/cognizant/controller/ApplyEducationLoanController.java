package com.cognizant.controller;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cognizant.entity.EducationLoan;
import com.cognizant.entity.UserDetails;
import com.cognizant.service.ApplyEducationLoanService;

@Controller
public class ApplyEducationLoanController {

	@Autowired
	ApplyEducationLoanService service;
	UserDetails user;

	private static final Logger LOG = Logger.getLogger(ApplyEducationLoanController.class);

	@RequestMapping(value = "/insertEducationLoan", method = RequestMethod.GET)
	public String getEducationLoan(Model model) {
		model.addAttribute("educationLoan", new EducationLoan());
		return "insertEducationLoan";
	}

	@RequestMapping(value = "/insertEducationLoan", method = RequestMethod.POST)
	public String initiateEducationLoan(@ModelAttribute("educationLoan") @Valid EducationLoan educationLoan,
			BindingResult result, Model model) {

		String id = service.generateLoanId(educationLoan.getIdCardNumber());
		educationLoan.setEducationLoanID(id);
		educationLoan.setEduLoanAccountNumber(service.generateLoanAccountNumber());

		try {
			service.updateEducationLoanDetails(educationLoan, 1234567890123546L);
		} catch (ConstraintViolationException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
			Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
			while (iterator.hasNext()) {
				ConstraintViolation<?> next = iterator.next();
				LOG.info("Validation message: " + next.getMessage());
				LOG.info("Invalid field: " + next.getPropertyPath());
				LOG.info("Validation class/bean: " + next.getRootBean());
				// result.reject(next.getPropertyPath(), next.getMessage());
				result.rejectValue(next.getPropertyPath().toString(), "", next.getMessage());
				// result.rejectValue(arg0, arg1, arg2);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("m1", educationLoan.getEducationLoanID());

		if (result.hasErrors()) {
			return "insertEducationLoan";
		}

		return "successEducationLoan";

	}
}