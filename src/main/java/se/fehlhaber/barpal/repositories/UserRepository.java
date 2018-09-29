package se.fehlhaber.barpal.repositories;

import org.springframework.data.repository.CrudRepository;

import se.fehlhaber.barpal.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findUserByUserName(String userName);
}
