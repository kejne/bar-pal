package se.fehlhaber.barpal.repositories;

import org.springframework.data.repository.CrudRepository;

import se.fehlhaber.barpal.entity.Product;

/**
 * Simple repository to fetch {@link Product}
 * 
 * @author Kaj Fehlhaber
 *
 */
public interface ProductRepository extends CrudRepository<Product, Long> {

	Product findByProductName(String productName);
}
