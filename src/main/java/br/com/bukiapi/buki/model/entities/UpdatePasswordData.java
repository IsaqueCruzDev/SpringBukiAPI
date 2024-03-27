package br.com.bukiapi.buki.model.entities;

public class UpdatePasswordData {
	private String password;

	public UpdatePasswordData() {
		
	}

	public UpdatePasswordData(String password) {
		super();
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
