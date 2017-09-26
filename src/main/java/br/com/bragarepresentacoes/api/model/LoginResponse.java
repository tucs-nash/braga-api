package br.com.bragarepresentacoes.api.model;

import org.springframework.security.core.userdetails.User;

public class LoginResponse {

    private User user;
    private String token;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static LoginResponse of(User user, String token) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(token);
        loginResponse.setUser(user);
        return loginResponse;
    }
}
