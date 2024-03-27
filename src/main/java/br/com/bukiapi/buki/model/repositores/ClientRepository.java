package br.com.bukiapi.buki.model.repositores;

import org.springframework.data.repository.CrudRepository;

import br.com.bukiapi.buki.model.entities.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {
	
}
