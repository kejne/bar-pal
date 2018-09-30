package se.fehlhaber.barpal;

import org.springframework.beans.factory.annotation.Autowired;

import se.fehlhaber.barpal.entities.Product;
import se.fehlhaber.barpal.entities.User;
import se.fehlhaber.barpal.repositories.ProductRepository;
import se.fehlhaber.barpal.repositories.TransactionRepository;
import se.fehlhaber.barpal.repositories.UserRepository;

public abstract class AbstractBasicTests {

	// Product specific constants
	protected static final String PRODUCT_NAME = "TEST_PRODUCT_NAME";
	protected static final String PRODUCT_BARCODE = "7687689900023";
	protected static final long DEFAULT_PRICE = 10;
	
	//User specific constants
	protected static final String USER_NAME = "USER_NAME";
	protected static final String USER_HASH = "78676f7687687e68767687a6876876b766545c43433";
	protected static final String EMAIL = "barpal@fehlhaber.se";
	
	protected Product product;
	protected User user;
	
	
	@Autowired
	protected UserRepository userRepository;
	
	@Autowired
	protected TransactionRepository transactionRepository;
	
	@Autowired
	protected ProductRepository productRepository;
	
	protected User createGenericTestUser() {
		user = userRepository.findByUserName(USER_NAME);
		
		if (user == null) {
			user = new User(USER_NAME, USER_HASH, EMAIL);			
		}
		
		return userRepository.save(user);
	}
	
	protected Product createGenericTestProduct() {
		product = productRepository.findByProductName(PRODUCT_NAME);
		
		if (product == null) {
			product = new Product(PRODUCT_NAME, PRODUCT_BARCODE, DEFAULT_PRICE);			
		}
		
		return productRepository.save(product);
	}

}
