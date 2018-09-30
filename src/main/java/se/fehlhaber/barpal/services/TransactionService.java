package se.fehlhaber.barpal.services;

import org.springframework.stereotype.Service;

import se.fehlhaber.barpal.entities.Product;
import se.fehlhaber.barpal.entities.User;

@Service
public interface TransactionService {
	
	void registerPurchase(Product product, User user, long quantity);
	
}
