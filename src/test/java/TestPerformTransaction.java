package test.java;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.entity.TransactionDetails;
import com.cognizant.service.PerformTransactionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestPerformTransaction {

	@Autowired
	PerformTransactionService service;
	TransactionDetails transaction;

	@Before
	public void setUp() {
		transaction = new TransactionDetails("nhpjk", "DEPOSIT", 150001);
	}

	@Test
	public void testUpdateTransactionDetails() {
		System.out.println(transaction);
		service.updateTransactionDetails(transaction, 1234567890123546L);
		assertTrue(true);
	}

	// @Test
	public void retrieveTransactionDetails() {
		List<TransactionDetails> transactionDetails = service.retrieveTransactionDetails((long) 12345);
		assertEquals(transactionDetails.size(), 2);

	}

}
