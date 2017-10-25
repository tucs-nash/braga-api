package br.com.bragarepresentacoes.api.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.bragarepresentacoes.api.entity.ApiUser;
import br.com.bragarepresentacoes.api.repository.UserRepository;

@Service
public class ApiUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public ApiUserDetailsService(UserRepository adminUserRepository) {
        this.userRepository = adminUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        ApiUser adminUser = userRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("Username or password invalid!"));
        
        return new User(adminUser.getLogin(), adminUser.getPassword(), authority(adminUser));
    }
    
    private List<GrantedAuthority> authority(ApiUser adminUser) {
        return Arrays.asList(new SimpleGrantedAuthority(adminUser.getPermissionLevel().name()));
    }
}
