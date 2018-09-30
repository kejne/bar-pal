package se.fehlhaber.barpal.entities;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import se.fehlhaber.barpal.entities.enums.TransactionType;



/**
 * A transaction logged for each event in barpal like a purchase, added/removed credits
 * or returns.
 * 
 * @author Kaj Fehlhaber
 *
 */
@Entity
public class Transaction {

	public static final Transaction createPurchaseTransaction(long creditsDifference, long stockDifference, String productId, String userName) {
		return new Transaction(TransactionType.PURCHASE,creditsDifference,stockDifference,productId, userName);
	}

	public static final Transaction createReturnTransaction(long creditsDifference, long stockDifference, String productId, String userName) {
		return new Transaction(TransactionType.RETURN,creditsDifference,stockDifference,productId, userName);
	}

	public static final Transaction createCreditDepositTransaction(long creditsDifference, String userName) {
		return new Transaction(TransactionType.CREDIT_CHANGE,creditsDifference, userName);
	}

	protected Transaction(TransactionType type, long creditsDifference, long stockDifference, String productId, String userName) {
		this.transactionType = type;
		this.creditsDifference = creditsDifference;
		this.stockDifference = stockDifference;
		this.productId = productId;
		this.userName = userName;
		this.transactionDate = new Date();
	}
	
	protected Transaction(TransactionType type, long creditsDifference, String userName) {
		this.transactionType = type;
		this.creditsDifference = creditsDifference;
		this.userName = userName;
		this.transactionDate = new Date();
	}

	protected Transaction() {
	}

	@Id
	@GeneratedValue
	private long transactionId;

	@Enumerated(EnumType.STRING)
	@Column
	private TransactionType transactionType;

	@Column
	private long creditsDifference;

	@Column
	private long stockDifference;

	@Column
	private String productId;

	@Column
	private Date transactionDate;

	@Column
	private String userName;

	public long getTransactionId() {
		return transactionId;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public long getCreditsDifference() {
		return creditsDifference;
	}

	public long getStockDifference() {
		return stockDifference;
	}

	public String getProductId() {
		return productId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public String getUserName() {
		return userName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (creditsDifference ^ (creditsDifference >>> 32));
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + (int) (stockDifference ^ (stockDifference >>> 32));
		result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
		result = prime * result + (int) (transactionId ^ (transactionId >>> 32));
		result = prime * result + ((transactionType == null) ? 0 : transactionType.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		Transaction other = (Transaction) obj;
		if (creditsDifference != other.creditsDifference)
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (stockDifference != other.stockDifference)
			return false;
		if (transactionDate == null) {
			if (other.transactionDate != null)
				return false;
		} else if (!transactionDate.equals(other.transactionDate))
			return false;
		if (transactionId != other.transactionId)
			return false;
		if (transactionType != other.transactionType)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionType=" + transactionType
				+ ", creditsDifference=" + creditsDifference + ", stockDifference=" + stockDifference + ", productId="
				+ productId + ", transactionDate=" + transactionDate + ", userName=" + userName + "]";
	}
	
	
}
