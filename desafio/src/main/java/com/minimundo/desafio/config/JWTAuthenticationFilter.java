package com.minimundo.desafio.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minimundo.desafio.entities.Usuario;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	public static final String SECRET_JWT = "";
	private final AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	public Authentication attemptAuthentication (HttpServletRequest request, HttpServletResponse response)
		throws AuthenticationException {
		try {
			Usuario usuario = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
					(usuario.getNome(), usuario.getSenha(), new ArrayList()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse  response, 
											FilterChain chain, Authentication authResult) throws IOException, ServletException {
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authResult.getPrincipal();
		
		String role = userDetailsImpl.getAuthorities().stream().findFirst().get().toString();
		
		String token = JWT.create()
				.withSubject(userDetailsImpl.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis()+600000))
				.withClaim("permissao", role)
				.sign(Algorithm.HMAC256(SECRET_JWT));
		
		response.getWriter().write(token);
		response.getWriter().flush();
	}

}
