package br.com.bragarepresentacoes.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.bragarepresentacoes.api.service.CrudService;

public abstract class CrudController<S extends CrudService<E>, E> {

    @Autowired
    private S service;
    
    @GetMapping(produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Page<E>> listCompany(E filter, Pageable pageable) {
        return ResponseEntity.ok(service.list(filter, pageable));
    }

    @PostMapping
    public ResponseEntity<E> createCompany(@RequestBody E entity) {
        return ResponseEntity.ok(service.create(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<E> updateCompany(@PathVariable Long id, @RequestBody E entity) {
        return ResponseEntity.ok(service.update(entity, id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteCompany(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }    
}
