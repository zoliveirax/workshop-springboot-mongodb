package com.zoliveirax.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoliveirax.workshopmongo.domain.User;
import com.zoliveirax.workshopmongo.dto.UserDTO;
import com.zoliveirax.workshopmongo.repository.UserRepository;
import com.zoliveirax.workshopmongo.services.exception.ObjectNotFoundException;

//Método que impõe que este serviço possa ser injetado por outras classes
@Service
public class UserService {
	
//Anotação responsável por injeção de um objeto em uma classe de dados
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();	
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);	
	}
	
	public void delete(String id) {
		repo.deleteById(id);
	}

//Considerando o principio da Responsabilidade Única de classes, o objetivo desta implementação foi de aproveitar a instanciação do banco de dados para com a classe em questão, por esse motivo, sendo ele polêmico, não foi aplicado tal princípio.
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

}
