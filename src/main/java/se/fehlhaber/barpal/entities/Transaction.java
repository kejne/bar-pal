package se.fehlhaber.barpal.entities;

import java.util.Date;

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

	static final Transaction createPurchaseTransaction(long creditsDifference, long stockDifference, String productId, String userName) {
		return new Transaction(TransactionType.PURCHASE,creditsDifference,stockDifference,productId, userName);
	}

	static final Transaction createReturnTransaction(long creditsDifference, long stockDifference, String productId, String userName) {
		return new Transaction(TransactionType.RETURN,creditsDifference,stockDifference,productId, userName);
	}

	static final Transaction createCreditDepositTransaction(long creditsDifference, String userName) {
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
}
