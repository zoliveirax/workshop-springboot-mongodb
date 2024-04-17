package com.zoliveirax.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.zoliveirax.workshopmongo.domain.User;

// Método SpringData responsável por conectar a interface com o banco de dados
@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
}
