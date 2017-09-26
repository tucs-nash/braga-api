package br.com.bragarepresentacoes.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bragarepresentacoes.api.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public ResponseEntity<Iterable<User>> listUser() {
        return null;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        return null;
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable Long id) {
        return null;
    }
}
