package br.com.bragarepresentacoes.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.bragarepresentacoes.api.entity.ApiUser;
import br.com.bragarepresentacoes.api.entity.Order;
import br.com.bragarepresentacoes.api.repository.OrderRepository;
import br.com.bragarepresentacoes.api.repository.UserRepository;

@Service
public class OrderService implements CrudService<Order> {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<Order> list(Order entity, Pageable pageable) {
        return orderRepository.findAll(Example.of(entity), pageable);
    }

    @Override
    public Order create(Order entity) {
        entity.setUser(getUser());
        return orderRepository.save(entity);
    }

    @Override
    public Order update(Order entity, Long id) {
        entity.setId(id);
        return orderRepository.save(entity);
    }

    @Override
    public Long delete(Long id) {
        orderRepository.delete(id);
        return id;
    }

    private ApiUser getUser() {
        return userRepository.findOne(1L);
    }

}
