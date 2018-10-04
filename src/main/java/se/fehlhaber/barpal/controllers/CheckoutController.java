package se.fehlhaber.barpal.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import se.fehlhaber.barpal.json.CheckoutCart;

@RestController
public class CheckoutController {

	@PostMapping(value="/checkout")
	public String checkout(@RequestBody CheckoutCart cart) {
		System.out.println(cart);
		return cart.getEntries().get(0).getProductName();
	}
}