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

import br.com.bragarepresentacoes.api.entity.Order;

@Controller
@RequestMapping("/order")
public class OrderController {

    @GetMapping
    public ResponseEntity<Iterable<Order>> listOrder() {
        return null;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        return null;
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteOrder(@PathVariable Long id) {
        return null;
    }
}
