package br.com.bragarepresentacoes.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.bragarepresentacoes.api.entity.Client;

@Repository
public interface ClientRepository extends PagingAndSortingRepository<Client, Long>{

}
