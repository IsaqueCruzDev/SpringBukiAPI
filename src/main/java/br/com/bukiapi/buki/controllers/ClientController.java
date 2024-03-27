package br.com.bukiapi.buki.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bukiapi.buki.model.entities.Client;
import br.com.bukiapi.buki.model.entities.UpdatePasswordData;
import br.com.bukiapi.buki.model.repositores.ClientRepository;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	@PostMapping
	public String createClient(@ModelAttribute Client data) {
		Client client = new Client(data.getName(), data.getEmail(), data.getPassword());
		clientRepository.save(client);
		return "cliente criado com sucesso";
	}

	@PutMapping("/{id}")
	public String updateClient(@ModelAttribute Client updateClientData, @PathVariable long id) {
		Optional<Client> optionalClient = clientRepository.findById(id);

		if (optionalClient.isPresent()) {
			Client existingClient = optionalClient.get();

			if (updateClientData.getName() != null) {
				existingClient.setName(updateClientData.getName());
			}

			if (updateClientData.getEmail() != null) {
				existingClient.setEmail(updateClientData.getEmail());
			}

			if (updateClientData.getPassword() != null) {
				existingClient.setPassword(updateClientData.getPassword());
			}

			clientRepository.save(existingClient);

			return "Cliente editado com sucesso";
		} else {
			return "Cliente não encontrado" + id;
		}
	}

	@PatchMapping("/updatepassword/{id}")
	public String updatePassword(@ModelAttribute UpdatePasswordData updatePasswordData, @PathVariable Long id) {
		Optional<Client> optionalClient = clientRepository.findById(id);

		if (optionalClient.isPresent()) {
			
			Client existingClient = optionalClient.get();
			
			if (updatePasswordData.getPassword() != null) {
				existingClient.setPassword(updatePasswordData.getPassword());
			}
			
			clientRepository.save(existingClient);
			
			return "Senha atualizada com sucesso!";
			
		} else {
			return "Cliente não encontrado" + id;
		}
	}

	@DeleteMapping("/{id}")
	public String deleteClient(@PathVariable Long id) {
		Optional<Client> optionalClient = clientRepository.findById(id);

		if (optionalClient.isPresent()) {
			clientRepository.deleteById(id);
			return "Cliente deletado com sucesso!";
		} else {
			return "Cliente não encontrado" + id;
		}
	}

//	Ao tentar receber o body usando '@RequestBody' eu recebi um error, então troquei por ModelAttribute
//	que foi recomendado no stackoverflow
}
