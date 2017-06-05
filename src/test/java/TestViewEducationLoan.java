package test.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.entity.EducationLoan;
import com.cognizant.service.ViewEducationLoanService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestViewEducationLoan {

	@Autowired
	ViewEducationLoanService vservice;
	private List<EducationLoan> eduLoan = new ArrayList<EducationLoan>();

	/*
	 * @Test public void test() { System.out.println("1"); eduLoan=
	 * vservice.retriveEducationLoanDetails(1234567994124577L);
	 * System.out.println("end"); System.out.println(eduLoan); }
	 */

}
