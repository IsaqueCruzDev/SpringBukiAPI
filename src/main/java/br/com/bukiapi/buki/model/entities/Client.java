package br.com.bukiapi.buki.model.entities;

import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

@Entity
public class Client implements UserDetails, Serializable { // o UserDetails vem do spring security e serve para mostrar ao spring qual
												// é a entidade dos usuários que serão autenticados

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String username;
	private String email;
	private String password;
	private int role;

	public Client() {

	}

	public Client(String name, String username, String email, String password, int role) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public String getName() {
		return name;
	}

//	public String getUsername() {
//		return username;
//	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public String getPassword() {
//		return password;
//	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Retorna a lista de autorizações (roles) do usuário
        return null;
    }

    @Override
    public String getPassword() {
        // Retorna a senha do usuário
        return null;
    }

    @Override
    public String getUsername() {
        // Retorna o nome de usuário do usuário
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        // Retorna true se a conta do usuário não estiver expirada
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Retorna true se a conta do usuário não estiver bloqueada
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Retorna true se as credenciais do usuário não estiverem expiradas
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Retorna true se o usuário estiver habilitado
        return true;
    }

}
