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

import br.com.bragarepresentacoes.api.entity.Agent;

@Controller
@RequestMapping("/agent")
public class AgentController {

    @GetMapping
    public ResponseEntity<Iterable<Agent>> listAgent() {
        return null;
    }

    @PostMapping
    public ResponseEntity<Agent> createAgent(@RequestBody Agent agent) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agent> updateAgent(@PathVariable Long id, @RequestBody Agent agent) {
        return null;
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteAgent(@PathVariable Long id) {
        return null;
    }
}
