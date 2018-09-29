package se.fehlhaber.barpal.repositories;

import org.springframework.data.repository.CrudRepository;

import se.fehlhaber.barpal.entities.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

	Transaction findByUserName(String userName);
}
