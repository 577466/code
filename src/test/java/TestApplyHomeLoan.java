package test.java;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.entity.HomeLoan;
import com.cognizant.entity.UserDetails;
import com.cognizant.service.ApplyHomeLoanService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
public class TestApplyHomeLoan {
	private UserDetails userDetails;
	private List<HomeLoan> homeLoan = new ArrayList<HomeLoan>();
	@Autowired
	ApplyHomeLoanService applyHomeLoanService;

	@Before
	public void setup() throws ParseException {
		userDetails = new UserDetails(1234567890123546L, "saving", "Aman", 4785655);

		HomeLoan e6 = new HomeLoan(12378, 3, "2018-07-26", 22000, "ford", "manager", 8, 2, userDetails);
		HomeLoan e7 = new HomeLoan(123, 7, "2017-06-02", 88000, "hella", "manager", 7, 2, userDetails);

		System.out.println("12");
		long loanACCNum = applyHomeLoanService.generateLoanAccNumber();
		long loanACCNum1 = applyHomeLoanService.generateLoanAccNumber();
		String id = applyHomeLoanService.generateRandomNumber(userDetails.getAccountNumber());
		System.out.println(id);
		e6.setLoanAccountNumber(loanACCNum);
		System.out.println(loanACCNum);
		e7.setLoanAccountNumber(loanACCNum1);
		System.out.println(loanACCNum1);
		e6.setHomeLoanId(id);
		e7.setHomeLoanId(id);
		homeLoan.add(e6);
		homeLoan.add(e7);
		System.out.println(e6);
		System.out.println(e7);

	}

	@Test
	public void testApplyHomeLoan() {
		System.out.println("13");

		userDetails.setHomeLoan(homeLoan);
		System.out.println(userDetails);
		System.out.println(homeLoan);
		applyHomeLoanService.insertHomeDetails(userDetails);
		System.out.println("14");

	}

	// @Test
	public void updateHomeLoanDetails() throws ParseException {
		HomeLoan e8 = new HomeLoan(125, 7, "20-12-2017", 88700, "cogni", "manager", 9, 4, userDetails);
		long loanACCNum = applyHomeLoanService.generateLoanAccNumber();
		String id = applyHomeLoanService.generateRandomNumber(1234567890123456l);
		e8.setHomeLoanId(id);
		e8.setLoanAccountNumber(loanACCNum);
		applyHomeLoanService.updateHomeLoanDetails(1234567890123456l, e8);
	}

}
