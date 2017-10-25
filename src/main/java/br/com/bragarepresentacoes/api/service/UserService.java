package br.com.bragarepresentacoes.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.bragarepresentacoes.api.entity.ApiUser;
import br.com.bragarepresentacoes.api.repository.UserRepository;

@Service
public class UserService implements CrudService<ApiUser> {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public Page<ApiUser> list(ApiUser entity, Pageable pageable) {
        return userRepository.findAll(Example.of(entity), pageable);
    }

    @Override
    public ApiUser create(ApiUser entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return userRepository.save(entity);
    }

    @Override
    public ApiUser update(ApiUser entity, Long id) {
        entity.setId(id);
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        return userRepository.save(entity);
    }

    @Override
    public Long delete(Long id) {
        userRepository.delete(id);
        return id;
    }

}
