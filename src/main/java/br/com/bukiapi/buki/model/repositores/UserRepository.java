package br.com.bukiapi.buki.model.repositores;

import org.springframework.data.repository.CrudRepository;

import br.com.bukiapi.buki.model.entities.user.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends CrudRepository<User, Long> {
	UserDetails findByUsername(String username);
}
