package br.com.bukiapi.buki.controllers;

import br.com.bukiapi.buki.infra.security.TokenService;
import br.com.bukiapi.buki.model.entities.user.AuthenticationDTO;
import br.com.bukiapi.buki.model.entities.user.RegisterDTO;
import br.com.bukiapi.buki.model.entities.user.User;
import br.com.bukiapi.buki.model.repositores.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        try {
            System.out.println("data " + data);
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
            var auth = this.authenticationManager.authenticate(usernamePassword);

            var token = tokenService.generateToken((User) auth.getPrincipal());

            User user = (User) userRepository.findByUsername(data.login());
            var userReturn = {
                    name: user.getName(),
                    username: user.getUsername(),
                    email: user.getEmail(),
            };
            return ResponseEntity.ok(user);
        } catch (AuthenticationException e) {
            System.out.println("Erro de autenticação: " + e.getMessage());
            return ResponseEntity.status(401).body("Erro de autenticação: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return ResponseEntity.status(500).body("Erro interno do servidor: " + e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if (this.userRepository.findByUsername(data.username()) != null) {
            return ResponseEntity.badRequest().build();
        } else {
            String encripytedPassword = new BCryptPasswordEncoder().encode(data.password());
            User user = new User(data.name(), data.username(), data.email(), encripytedPassword);
            userRepository.save(user);
            return ResponseEntity.ok().build();
        }
    }
}
