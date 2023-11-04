package br.ufrn.imd.ITHelper.controller;

import br.ufrn.imd.ITHelper.config.Views;
import br.ufrn.imd.ITHelper.dto.Login;
import br.ufrn.imd.ITHelper.exception.UserNotFoundException;
import br.ufrn.imd.ITHelper.security.TokenService;
import br.ufrn.imd.ITHelper.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import br.ufrn.imd.ITHelper.model.User;
import br.ufrn.imd.ITHelper.repository.UserRepository;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;

    }

    @PostMapping("/login")
    public String login(@RequestBody Login login) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                login.login(), login.password());
        Authentication authenticate = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        var user = (User) authenticate.getPrincipal();

        return tokenService.gerarToken(user);

    }

    @PostMapping("/register")
    @JsonView(Views.Public.class)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    // ListarTodos apenas se autenticado
    @GetMapping("/users")
    @JsonView(Views.Admin.class)
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/users/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        Integer userID = Integer.parseInt(id);
        User user = userRepository.findById(userID);
        if (user != null) {
            return ResponseEntity.ok(user); // Retorna 200 OK com o objeto User
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found se o usuário não for encontrado
        }
    }
    @GetMapping("/users/{login}")
    public ResponseEntity<User> getUserByLogin(@PathVariable String login) {
        User user = userRepository.findByLogin(login);
        if (user != null) {
            return ResponseEntity.ok(user); // Retorna 200 OK com o objeto User
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found se o usuário não for encontrado
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable String id, @RequestBody User updatedUser) {
        User user = userService.updateUser(id, updatedUser);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário "+ user.getLogin() +" atualizado com sucesso");
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        Integer userID = Integer.parseInt(id);
        userRepository.deleteById(userID);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário com id " + id + " excluído com sucesso");
    }
}
