package com.minimundo.desafio.config;

import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTValidateFilter extends BasicAuthenticationFilter {
;
	public static final String PREFIX = "Bearer ";
	
	public JWTValidateFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String path = request.getServletPath();
		if (path.startsWith("/desafio/swagger-ui") || path.startsWith("/v3/api-docs")) {
			chain.doFilter(request, response);
			return;
		}
		
		String atributo = request.getHeader("Authorization");
		
		if(!Optional.ofNullable(atributo).isPresent() || !atributo.startsWith(PREFIX)) {
			chain.doFilter(request, response);
			return;
		}
		
		if(!atributo.startsWith(PREFIX)) {
			chain.doFilter(request, response);
			return;
		}
		
		String token = atributo.replace(PREFIX, "");
		
		UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(token);
		
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		chain.doFilter(request, response);
	}

	private UsernamePasswordAuthenticationToken getAuthentication(String token) {
		DecodedJWT decodedJWT = JWT
				.require(Algorithm.HMAC256(JWTAuthenticationFilter.secretJwt))
				.build().verify(token);
		
		String usuario = decodedJWT.getSubject();
		
		String permissao = decodedJWT.getClaim("permissao").asString();
		permissao = "ROLE_"+permissao;
		
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(permissao);
		Set<GrantedAuthority> authorities = new HashSet();
		authorities.add(authority);
		
		if (Optional.ofNullable(usuario).isPresent()) {
			return new UsernamePasswordAuthenticationToken(usuario, null, authorities);
		}
		return null;
	}	

}
