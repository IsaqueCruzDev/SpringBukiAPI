package br.com.bukiapi.buki.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	public int id;
	public String name;
	
	public String email;
	public int idade;
	public String cpf;
	public String street;
	public int streetNumber;
	public String neighborhood;
	public String city;
	public String state;

	// ALT + Z + S

	public User(int id, String name, String email, int idade, String cpf, String street, int streetNumber,
			String neighborhood, String city, String state) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.idade = idade;
		this.cpf = cpf;
		this.street = street;
		this.streetNumber = streetNumber;
		this.neighborhood = neighborhood;
		this.city = city;
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public int getIdade() {
		return idade;
	}

	public String getStreet() {
		return street;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getCpf() {
		return cpf;
	}

}
