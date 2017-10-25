package br.com.bragarepresentacoes.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.bragarepresentacoes.api.entity.Company;
import br.com.bragarepresentacoes.api.repository.CompanyRepository;

@Service
public class CompanyService implements CrudService<Company> {

    @Autowired
    private CompanyRepository companyRepository;
    
    @Override
    public Page<Company> list(Company entity, Pageable pageable) {
        return companyRepository.findAll(Example.of(entity), pageable);
    }

    @Override
    public Company create(Company entity) {
        return companyRepository.save(entity);
    }

    @Override
    public Company update(Company entity, Long id) {
        entity.setId(id);
        return companyRepository.save(entity);
    }

    @Override
    public Long delete(Long id) {
        companyRepository.delete(id);
        return id;
    }

}
