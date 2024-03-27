package br.com.bukiapi.buki.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.bukiapi.buki.model.entities.User;

@RestController
@RequestMapping("/user")
public class UserController {

//	O Request param espera receber a propriedade como query string
	@RequestMapping(method = RequestMethod.GET)
	public int getUser(@RequestParam(name = "id") int id) {
		return id;
	}

//	PathVariable é usado nos casos de rotas que esperam um valor através da URL
//	mas sem ser uma query string, por exemplo "/user/{id}". 
//	O id não está vindo como uma query tring, e sim como um valor adicional na URL
	@PostMapping("/{id}")
	public int createUser(@PathVariable int id) {
		return id;
	}
}
