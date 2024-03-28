package br.com.bukiapi.buki.model.entities.user;

public record RegisterDTO(String name, String username, String email, String password, UserRole role) {
}
