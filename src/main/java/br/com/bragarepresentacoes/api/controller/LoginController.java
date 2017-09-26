package br.com.bragarepresentacoes.api.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.bragarepresentacoes.api.model.LoginRequest;
import br.com.bragarepresentacoes.api.model.LoginResponse;
import br.com.bragarepresentacoes.api.service.AuthenticationService;

@Controller
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/auth")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest request)
        throws UnsupportedEncodingException {
        return ResponseEntity.ok(authenticationService.authentication(request));
    }
}
