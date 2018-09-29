package se.fehlhaber.barpal.entities;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Table that holds all information about a specific product. Because barpal is supposed to be a simple 
 * application with all products in one location, quantity is also held within the same table.
 * 
 * @author Kaj Fehlhaber
 *
 */
@Entity
public class Product {

	protected Product() {}

	public Product(String productName, String barcode, long credits) {
		this.productName = productName;
		this.barcode = barcode;
		this.credits = credits;
	}
	
	@Id
	@GeneratedValue
	private long productKey;
	
	@Column
	private String productName;
	
	@Column
	private String barcode;
	
	@Column
	private long credits;
	
	@Column
	private long quantity = 0;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getProductKey() {
		return productKey;
	}


	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public long getCredits() {
		return credits;
	}

	public void setCredits(long credits) {
		this.credits = credits;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((barcode == null) ? 0 : barcode.hashCode());
		result = prime * result + (int) (credits ^ (credits >>> 32));
		result = prime * result + (int) (productKey ^ (productKey >>> 32));
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		return result;
	}

	@Generated(value = {"eclipse"})
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (barcode == null) {
			if (other.barcode != null)
				return false;
		} else if (!barcode.equals(other.barcode))
			return false;
		if (credits != other.credits)
			return false;
		if (productKey != other.productKey)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + "]";
	}
	
	
}
