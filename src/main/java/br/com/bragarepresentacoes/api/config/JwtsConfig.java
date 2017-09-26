package br.com.bragarepresentacoes.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties("jwts")
@Data
public class JwtsConfig {

    private String secretKeyLogin;
    private String tokenLogin;
    private String tokenPermissao;
    private Long expirationInMinutes;

}
