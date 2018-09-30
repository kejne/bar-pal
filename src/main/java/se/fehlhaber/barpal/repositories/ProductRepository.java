package se.fehlhaber.barpal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import se.fehlhaber.barpal.entities.Product;

/**
 * Simple repository to fetch {@link Product}
 * 
 * @author Kaj Fehlhaber
 *
 */
@Service
public interface ProductRepository extends CrudRepository<Product, Long> {

	Product findByProductName(String productName);
}
