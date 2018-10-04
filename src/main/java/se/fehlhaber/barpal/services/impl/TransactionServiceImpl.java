package se.fehlhaber.barpal.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import se.fehlhaber.barpal.entities.Product;
import se.fehlhaber.barpal.entities.Transaction;
import se.fehlhaber.barpal.entities.User;
import se.fehlhaber.barpal.repositories.ProductRepository;
import se.fehlhaber.barpal.repositories.TransactionRepository;
import se.fehlhaber.barpal.repositories.UserRepository;
import se.fehlhaber.barpal.services.TransactionService;

@Component
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public void registerPurchase(Product product, User user, long quantity) {
		long creditsDifference = product.getCredits() * quantity;

		product.addQuantity(-quantity);
		user.addCredits(-creditsDifference);
		
		Transaction transaction = Transaction.createPurchaseTransaction(-creditsDifference, -quantity, product.getProductName(), user.getUserName());
		transactionRepository.save(transaction);
	}
}
