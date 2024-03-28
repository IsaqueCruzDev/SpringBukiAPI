package br.com.bukiapi.buki.model.entities.user;

public enum UserRole {
    ADMIN("admin"),

    User("user");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        setRole(role);
    }
}
