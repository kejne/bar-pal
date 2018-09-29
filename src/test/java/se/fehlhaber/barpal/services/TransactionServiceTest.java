package se.fehlhaber.barpal.services;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import se.fehlhaber.barpal.AbstractBasicTests;
import se.fehlhaber.barpal.entities.Transaction;
import se.fehlhaber.barpal.repositories.TransactionRepository;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceTest extends AbstractBasicTests{

	private static final long QUANTITY = 2;

	@InjectMocks
	private TransactionService testee;
	
	private Transaction resultingTransaction;
	
	@Before
	public void before() {
		testee.transactionRepository = new TestTransactionRepository();
		product = createGenericTestProduct();
		user = createGenericTestUser();
	}
	
	@Test
	public void testUserNamedLogged() {
		testee.registerPurchase(product, user, QUANTITY);
		assertEquals(USER_NAME, resultingTransaction.getUserName());
		assertEquals(PRODUCT_NAME, resultingTransaction.getProductId());
		assertEquals(-QUANTITY, resultingTransaction.getStockDifference());
		assertEquals(-QUANTITY*DEFAULT_PRICE, resultingTransaction.getCreditsDifference());
	}
	
	private class TestTransactionRepository implements TransactionRepository {

		@Override
		public <S extends Transaction> S save(S entity) {
			resultingTransaction = entity;
			return null;
		}

		@Override
		public <S extends Transaction> Iterable<S> saveAll(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Optional<Transaction> findById(Long id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean existsById(Long id) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterable<Transaction> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterable<Transaction> findAllById(Iterable<Long> ids) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long count() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void deleteById(Long id) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(Transaction entity) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll(Iterable<? extends Transaction> entities) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Transaction findByUserName(String userName) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
