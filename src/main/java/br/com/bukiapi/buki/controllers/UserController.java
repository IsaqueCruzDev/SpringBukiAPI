package br.com.bukiapi.buki.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bukiapi.buki.model.entities.user.User;
import br.com.bukiapi.buki.model.entities.user.UserPasswordData;
import br.com.bukiapi.buki.model.repositores.UserRepository;

@RestController
@RequestMapping("/client")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public Iterable<User> getClients() {
		return userRepository.findAll();
	}

	@PostMapping
	public String createClient(@ModelAttribute User data) {
		User user = new User(data.getName(), data.getUsername(), data.getEmail(), data.getPassword(),
				data.getRole());
		userRepository.save(user);
		return "cliente criado com sucesso";
	}

	@PutMapping("/{id}")
	public String updateClient(@ModelAttribute User updateUserData, @PathVariable long id) {
		Optional<User> optionalClient = userRepository.findById(id);

		if (optionalClient.isPresent()) {
			User existingUser = optionalClient.get();

			if (updateUserData.getName() != null) {
				existingUser.setName(updateUserData.getName());
			}

			if (updateUserData.getEmail() != null) {
				existingUser.setEmail(updateUserData.getEmail());
			}

			if (updateUserData.getPassword() != null) {
				existingUser.setPassword(updateUserData.getPassword());
			}

			userRepository.save(existingUser);

			return "Cliente editado com sucesso";
		} else {
			return "Cliente não encontrado" + id;
		}
	}

	@PatchMapping("/updatepassword/{id}")
	public String updatePassword(@ModelAttribute UserPasswordData updatePasswordData, @PathVariable Long id) {
		Optional<User> optionalClient = userRepository.findById(id);

		if (optionalClient.isPresent()) {

			User existingUser = optionalClient.get();

			if (updatePasswordData.getPassword() != null) {
				existingUser.setPassword(updatePasswordData.getPassword());
			}

			userRepository.save(existingUser);

			return "Senha atualizada com sucesso!";

		} else {
			return "Cliente não encontrado" + id;
		}
	}

	@DeleteMapping("/{id}")
	public String deleteClient(@PathVariable Long id) {
		Optional<User> optionalClient = userRepository.findById(id);

		if (optionalClient.isPresent()) {
			userRepository.deleteById(id);
			return "Cliente deletado com sucesso!";
		} else {
			return "Cliente não encontrado" + id;
		}
	}

//	Ao tentar receber o body usando '@RequestBody' eu recebi um error, então troquei por ModelAttribute
//	que foi recomendado no stackoverflow
}
