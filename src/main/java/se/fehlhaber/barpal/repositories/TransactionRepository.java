package se.fehlhaber.barpal.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import se.fehlhaber.barpal.entities.Transaction;

@Service
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

	List<Transaction> findByUserName(String userName);
	
	Transaction findFirstByUserNameOrderByTransactionIdDesc(String userName);
}
