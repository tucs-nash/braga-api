package br.com.bragarepresentacoes.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import br.com.bragarepresentacoes.api.entity.Agent;
import br.com.bragarepresentacoes.api.repository.AgentRepository;

@Service
public class AgentService implements CrudService<Agent> {

    @Autowired
    public AgentRepository agentRepository;

    public Page<Agent> list(Agent agent, Pageable pageable) {
        return agentRepository.findAll(Example.of(agent), pageable);
    }

    public Agent create(Agent agent) {
        Assert.notNull(agent.getName(), "Name is mandatory");
        return agentRepository.save(agent);
    }

    public Agent update(Agent agent, Long id) {
        Assert.notNull(id, "Id is mandatory");
        Assert.notNull(agent.getName(), "Name is mandatory");
        agent.setId(id);
        return agentRepository.save(agent);
    }

    public Long delete(Long id) {
        Assert.notNull(id, "Id is mandatory");
        agentRepository.delete(id);
        return id;
    }

}
