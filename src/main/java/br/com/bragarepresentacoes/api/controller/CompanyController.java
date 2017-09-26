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

import br.com.bragarepresentacoes.api.entity.Company;

@Controller
@RequestMapping("/company")
public class CompanyController {

    @GetMapping
    public ResponseEntity<Iterable<Company>> listCompany() {
        return null;
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        return null;
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteCompany(@PathVariable Long id) {
        return null;
    }
}
