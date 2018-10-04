package se.fehlhaber.barpal.services.impl;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import se.fehlhaber.barpal.AbstractBasicTests;
import se.fehlhaber.barpal.entities.Product;
import se.fehlhaber.barpal.entities.Transaction;
import se.fehlhaber.barpal.entities.User;
import se.fehlhaber.barpal.services.TransactionService;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TransactionServiceTest extends AbstractBasicTests{

	private static final Logger logger = LogManager.getLogger(TransactionServiceTest.class);
	
	private static final long QUANTITY = 2;

	@Autowired
	TransactionService testee;
	
	protected Product product;
	protected User user;
	
	private Transaction resultingTransaction;

	@Before
	public void before() {
		product = createGenericTestProduct();
		user = createGenericTestUser();	
		System.out.println("Inserted " + product + ", and " + user);
	}
	
	@Test
	public void registerPurchaseProducesTransaction() {
					
		testee.registerPurchase(product, user, QUANTITY);
		resultingTransaction = transactionRepository.findFirstByUserNameOrderByTransactionIdDesc(USER_NAME);

		assertEquals(USER_NAME, resultingTransaction.getUserName());
		assertEquals(PRODUCT_NAME, resultingTransaction.getProductId());
		assertEquals(-QUANTITY, resultingTransaction.getStockDifference());
		assertEquals(-QUANTITY*DEFAULT_PRICE, resultingTransaction.getCreditsDifference());		
	}
	
	@Test
	public void registerPurchaseLowersQuantityOnHand() {
		product.setQuantity(QUANTITY);
		product = productRepository.save(product);
		
		testee.registerPurchase(product, user, QUANTITY);
		
		Product productAfterPurchase = productRepository.findByProductName(PRODUCT_NAME);
		assertEquals(0, productAfterPurchase.getQuantity());		
	}
	
	@Test
	public void registerPurchaseLowersCreditsForUser() throws Exception {
		user.setCredits(DEFAULT_PRICE*QUANTITY);
		user = userRepository.save(user);
		
		testee.registerPurchase(product, user, QUANTITY);
		
		User userAfterPurchase = userRepository.findByUserName(USER_NAME);
		assertEquals(0, userAfterPurchase.getCredits());
	}
	
	@After
	public void logAfter() {
		logger.info("Completed test - Created {}", resultingTransaction);
	}
}
