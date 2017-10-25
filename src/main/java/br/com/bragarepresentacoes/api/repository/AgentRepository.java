package br.com.bragarepresentacoes.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import br.com.bragarepresentacoes.api.entity.Agent;

@Repository
public interface AgentRepository extends PagingAndSortingRepository<Agent, Long>, QueryByExampleExecutor<Agent> {

}
