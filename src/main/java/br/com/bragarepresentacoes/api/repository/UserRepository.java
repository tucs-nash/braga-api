package br.com.bragarepresentacoes.api.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import br.com.bragarepresentacoes.api.entity.ApiUser;

@Repository
public interface UserRepository extends PagingAndSortingRepository<ApiUser, Long>, QueryByExampleExecutor<ApiUser> {

    Optional<ApiUser> findByLogin(String login);

}
