package se.fehlhaber.barpal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import se.fehlhaber.barpal.entities.User;

@Service
public interface UserRepository extends CrudRepository<User, Long> {

	User findByUserName(String userName);
}
