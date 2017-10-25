package br.com.bragarepresentacoes.api.service;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import br.com.bragarepresentacoes.api.model.LoginRequest;
import br.com.bragarepresentacoes.api.model.LoginResponse;
import br.com.bragarepresentacoes.api.util.TokenReader;

@Service
public class AuthenticationService {

    @Autowired
    private TokenReader tokenReader;
    
    @Autowired
    private AuthenticationManager authManager;
    
    public LoginResponse authentication(LoginRequest request) throws UnsupportedEncodingException {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                request.getLogin(), request.getPassword());
        
        Authentication authentication = this.authManager.authenticate(authenticationToken);
        User user = (User) authentication.getPrincipal();
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        return LoginResponse.of(user, tokenReader.generateLoginToken(user));
    }

}
