package se.fehlhaber.barpal.services.impl;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import se.fehlhaber.barpal.json.CartEntry;
import se.fehlhaber.barpal.json.CheckoutCart;
import se.fehlhaber.barpal.services.TransactionService;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutServiceTest {

	private static final String TEST_PRODUCT = "Slots guld";
	
	@InjectMocks
	CheckoutServiceImpl testee;
	
	@Mock
	TransactionService tranaactionServiceMock;
	
	@Test
	public void test() {
		CartEntry cartEntry = new CartEntry(TEST_PRODUCT,1);
		List<CartEntry> cartEntries = Arrays.asList(cartEntry);
		CheckoutCart cart = new CheckoutCart(cartEntries);
		
		
		testee.checkout(cart);
		
	}

}
