package se.fehlhaber.barpal;

import se.fehlhaber.barpal.entities.Product;
import se.fehlhaber.barpal.entities.User;

public abstract class AbstractBasicTests {

	// Product specific constants
	public static final String PRODUCT_NAME = "TEST_PRODUCT_NAME";
	public static final String PRODUCT_BARCODE = "7687689900023";
	public static final long DEFAULT_PRICE = 10;
	
	//User specific constants
	public static final String USER_NAME = "USER_NAME";
	public static final String USER_HASH = "78676f7687687e68767687a6876876b766545c43433";
	public static final String EMAIL = "barpal@fehlhaber.se";
	
	protected Product product;
	protected User user;
	
	protected User createGenericTestUser() {
		return new User(USER_NAME, USER_HASH, EMAIL);
	}
	
	protected Product createGenericTestProduct() {
		return new Product(PRODUCT_NAME, PRODUCT_BARCODE, DEFAULT_PRICE);
	}
}
