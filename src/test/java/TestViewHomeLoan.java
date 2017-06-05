package test.java;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.entity.HomeLoan;
import com.cognizant.service.ViewHomeLoanService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
public class TestViewHomeLoan {

	@Autowired
	ViewHomeLoanService viewHOmeLoanService;
	private List<HomeLoan> homeLoan = new ArrayList<HomeLoan>();

	@Test
	public void test() {
		System.out.println("1");

		homeLoan = viewHOmeLoanService.retrieveHomeDetails(1234567890123456l);
		System.out.println(homeLoan);
	}

}
