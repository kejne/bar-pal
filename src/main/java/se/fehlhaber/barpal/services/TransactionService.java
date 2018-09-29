package se.fehlhaber.barpal.services;

import org.springframework.beans.factory.annotation.Autowired;

import se.fehlhaber.barpal.entities.Product;
import se.fehlhaber.barpal.entities.Transaction;
import se.fehlhaber.barpal.entities.User;
import se.fehlhaber.barpal.repositories.TransactionRepository;

public class TransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;

	public void registerPurchase(Product product, User user, long quantity) {
		long creditsDifference = product.getCredits() * -quantity;
		
		Transaction transaction = Transaction.createPurchaseTransaction(creditsDifference, -quantity, product.getProductName(), user.getUserName());
		transactionRepository.save(transaction);
	}
}
