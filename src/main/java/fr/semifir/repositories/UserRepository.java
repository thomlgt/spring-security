package fr.semifir.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.semifir.models.User;

public interface UserRepository extends MongoRepository<User, String>{

	public User findByUsername(String username);
}
