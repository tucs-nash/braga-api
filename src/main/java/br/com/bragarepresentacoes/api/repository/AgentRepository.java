package br.com.bragarepresentacoes.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.bragarepresentacoes.api.entity.Agent;

@Repository
public interface AgentRepository extends CrudRepository<Agent, Long>{

}
