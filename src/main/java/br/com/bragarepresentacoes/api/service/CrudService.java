package br.com.bragarepresentacoes.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CrudService<T> {

    Page<T> list(T entity, Pageable pageable);
    T create(T entity);
    T update(T entity, Long id);
    Long delete(Long id);
}
