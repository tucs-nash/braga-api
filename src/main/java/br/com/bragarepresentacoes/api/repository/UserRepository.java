package br.com.bragarepresentacoes.api.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.bragarepresentacoes.api.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

    Optional<User> findByLogin(String login);

}
