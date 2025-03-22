package com.minimundo.desafio.config;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.minimundo.desafio.entities.Usuario;
import com.minimundo.desafio.repositories.UsuarioRepository;
import com.minimundo.desafio.services.UsuarioService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private final UsuarioService usuarioService;

	public UserDetailsServiceImpl(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioService.getUsuarioAutenticacao(username);
		if(!usuario.isPresent())
			new UsernameNotFoundException("Usuário não encontrado!");
		
		return new UserDetailsImpl(usuario);
	}

}
