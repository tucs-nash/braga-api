package br.com.bragarepresentacoes.api.web.filter;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class ApiFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        try {
            if (!request.getRequestURI().equals("/auth")) {
                String token = request.getHeader("Authorization");
                
                if(Objects.isNull(token)) {
                    throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);                    
                }
            } 
            filterChain.doFilter(request, response);
        } catch (HttpClientErrorException e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

}
