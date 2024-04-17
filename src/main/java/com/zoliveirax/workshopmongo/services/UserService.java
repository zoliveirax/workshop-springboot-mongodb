package com.zoliveirax.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoliveirax.workshopmongo.domain.User;
import com.zoliveirax.workshopmongo.repository.UserRepository;

//Método que impõe que este serviço possa ser injetado por outras classes
@Service
public class UserService {
	
//Anotação responsável por injeção de um objeto em uma classe de dados
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();	
	}

}