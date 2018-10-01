package se.fehlhaber.barpal.repositories;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import se.fehlhaber.barpal.AbstractBasicTests;
import se.fehlhaber.barpal.entities.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProductRepositoryTest extends AbstractBasicTests {

	@Autowired
	ProductRepository testee;
	
	@Test
	public void findByProductName() {
		createNGenericTestProducts(10);
		Product foundProduct = testee.findByProductName(PRODUCT_NAME + 3);
		
		assertEquals(PRODUCT_NAME + 3, foundProduct.getProductName());
	}
	
	@Test
	public void findByBarcode() {
		createNGenericTestProducts(10);
		Product foundProduct = testee.findByBarcode(PRODUCT_BARCODE + 4);
		
		assertEquals(PRODUCT_NAME + 4, foundProduct.getProductName());
	}

}
