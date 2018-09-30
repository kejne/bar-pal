package se.fehlhaber.barpal.services;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import se.fehlhaber.barpal.AbstractBasicTests;
import se.fehlhaber.barpal.entities.Transaction;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionServiceTest extends AbstractBasicTests{

	private static final long QUANTITY = 2;

	@Autowired
	TransactionService testee;
	
	private Transaction resultingTransaction;

	private void registerPurchaseAtTestee() {
		testee.registerPurchase(product, user, QUANTITY);
		resultingTransaction = transactionRepository.findFirstByUserNameOrderByTransactionIdDesc(USER_NAME);
	}
		
	@Before
	public void before() {
		product = createGenericTestProduct();
		user = createGenericTestUser();	
		System.out.println("Inserted " + product + ", and " + user);
		registerPurchaseAtTestee();		
	}
	
	@Test
	public void testUserNamedLogged() {
		assertEquals(USER_NAME, resultingTransaction.getUserName());
	}
	
	@Test
	public void testProductLogged() throws Exception {
		assertEquals(PRODUCT_NAME, resultingTransaction.getProductId());
	}
	
	@Test
	public void testQuantityDifferencesLogged() throws Exception {
		assertEquals(-QUANTITY, resultingTransaction.getStockDifference());
		assertEquals(-QUANTITY*DEFAULT_PRICE, resultingTransaction.getCreditsDifference());		
	}
	
	@After
	public void logAfter() {
		System.out.println("Completed test - Created " + resultingTransaction);
	}
}
