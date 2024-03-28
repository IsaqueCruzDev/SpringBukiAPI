package br.com.bukiapi.buki.controllers;

import br.com.bukiapi.buki.model.entities.user.AuthenticationDTO;
import br.com.bukiapi.buki.model.entities.user.RegisterDTO;
import br.com.bukiapi.buki.model.entities.user.User;
import br.com.bukiapi.buki.model.repositores.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
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
