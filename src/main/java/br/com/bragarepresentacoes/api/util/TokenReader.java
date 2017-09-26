package br.com.bragarepresentacoes.api.util;

import java.io.UnsupportedEncodingException;
import java.security.SignatureException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import br.com.bragarepresentacoes.api.config.JwtsConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class TokenReader {

    private JwtsConfig jwtsConfig;

    public boolean isValidLoginToken(String token) throws UnsupportedJwtException, MalformedJwtException,
        SignatureException, IllegalArgumentException, UnsupportedEncodingException {
        return getClaims(token, true).containsKey(jwtsConfig.getTokenLogin());
    }

    public String generateLoginToken(User user) throws UnsupportedEncodingException {
        LocalDateTime ldt = LocalDateTime.now().plusMinutes(jwtsConfig.getExpirationInMinutes());
        return Jwts.builder().setExpiration(Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant()))
                .claim(jwtsConfig.getTokenLogin(), user.getUsername())
                .signWith(SignatureAlgorithm.HS256, jwtsConfig.getSecretKeyLogin())
                .compact();
    }

    private Claims getClaims(String token, boolean isLogin) {
        try {
            return Jwts.parser().setSigningKey(jwtsConfig.getSecretKeyLogin()).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        }
    }
}
