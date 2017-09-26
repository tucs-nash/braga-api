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

import br.com.bragarepresentacoes.api.entity.Client;

@Controller
@RequestMapping("/client")
public class ClientController {

    @GetMapping
    public ResponseEntity<Iterable<Client>> listClient() {
        return null;
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        return null;
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteClient(@PathVariable Long id) {
        return null;
    }
}
