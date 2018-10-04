package se.fehlhaber.barpal.services;

import org.springframework.beans.factory.annotation.Autowired;

import se.fehlhaber.barpal.json.CheckoutCart;
import se.fehlhaber.barpal.repositories.ProductRepository;

/**
 * Service is responsible for handling any actions during the check out process of an item from the storage
 * @author Kaj Fehlhaber
 *
 */
public interface CheckoutService {

	/**
	 * Checks out cart, reducing the quantity in stock and substracting the credits from the user
	 * @param cart
	 */
	void checkout(CheckoutCart cart);
	
	
}
