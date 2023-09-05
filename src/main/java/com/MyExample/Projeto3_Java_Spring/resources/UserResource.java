package com.MyExample.Projeto3_Java_Spring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.MyExample.Projeto3_Java_Spring.domain.User;
import com.MyExample.Projeto3_Java_Spring.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	//Declarando "injeção de dependência" para os serviço
	
	@Autowired
	private UserService service;
	
	
	//Declarando de endpoints:
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		
		//(TESTE)
		//Instanciando usuários de forma manual, para poder fazer a requisição no Postman 
		//User maria = new User("1", "Maria Brown", "ma@gmail.com");
		//List<User> list = new ArrayList<>();
		//list.addAll(Arrays.asList(maria));
		//return ResponseEntity.ok().body(list);
		
		
		//Recuperando usuários direto do MongoDB
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
