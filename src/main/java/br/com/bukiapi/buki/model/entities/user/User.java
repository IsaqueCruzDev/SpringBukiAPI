package br.com.bukiapi.buki.model.entities.user;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class User implements UserDetails, Serializable { // o UserDetails vem do spring security e serve para mostrar ao spring qual
												// é a entidade dos usuários que serão autenticados
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String username;
	private String email;
	private String password;
	private UserRole role;

	public User() {

	}

	public User(String name, String username, String email, String password) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public User(String name, String username, String email, String password, UserRole role) {
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

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
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
		if (this.role == UserRole.ADMIN)
			return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
		else
			return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        // Retorna a senha do usuário
        return password;
    }

    @Override
    public String getUsername() {
        // Retorna o nome de usuário do usuário
        return username;
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
