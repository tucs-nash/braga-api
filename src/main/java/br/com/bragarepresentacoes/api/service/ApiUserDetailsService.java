package br.com.bragarepresentacoes.api.service;

import java.util.Collections;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.bragarepresentacoes.api.entity.User;
import br.com.bragarepresentacoes.api.repository.UserRepository;

@Service
public class ApiUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public ApiUserDetailsService(UserRepository adminUserRepository) {
        this.userRepository = adminUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User adminUser = userRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("Username or password invalid!"));
        return new org.springframework.security.core.userdetails.User(adminUser.getLogin(), adminUser.getPassword(),
                Collections.emptyList());
    }
}
