package com.minimundo.desafio.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
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
	
	public static final String secretJwt = "5b46941e-8b0d-4b30-9678-e6cb5656985b";
	private final AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	@Override
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
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse  response, 
											FilterChain chain, Authentication authResult) throws IOException, ServletException {
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authResult.getPrincipal();
		
		String role = userDetailsImpl.getAuthorities().stream().findFirst().get().toString();
		
		String token = JWT.create()
				.withSubject(userDetailsImpl.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis()+600000))
				.withClaim("permissao", role)
				.sign(Algorithm.HMAC256(secretJwt));
	    
		System.out.println(token);
		
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    
	    
	    String jsonResponse = String.format(token);
		System.out.println(jsonResponse);
		response.getWriter().write(jsonResponse);
		response.getWriter().flush();
		response.getWriter().close();
		
		response.addHeader("Authorization", "Bearer " + token);
	}

}
