package br.com.bragarepresentacoes.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.bragarepresentacoes.api.entity.ApiUser;
import br.com.bragarepresentacoes.api.entity.Client;
import br.com.bragarepresentacoes.api.repository.ClientRepository;
import br.com.bragarepresentacoes.api.repository.UserRepository;

@Service
public class ClientService implements CrudService<Client> {

    @Autowired
    private ClientRepository clientRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public Page<Client> list(Client entity, Pageable pageable) {
        return clientRepository.findAll(Example.of(entity), pageable);
    }

    @Override
    public Client create(Client entity) {
        entity.setUser(getUser());
        return clientRepository.save(entity);
    }

    @Override
    public Client update(Client entity, Long id) {
        entity.setId(id);
        return clientRepository.save(entity);
    }

    @Override
    public Long delete(Long id) {
        clientRepository.delete(id);
        return id;
    }

    private ApiUser getUser() {
        return userRepository.findOne(1L);
    }
}
