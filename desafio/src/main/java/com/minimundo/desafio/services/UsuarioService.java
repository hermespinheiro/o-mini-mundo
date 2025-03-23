package com.minimundo.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.minimundo.desafio.entities.Usuario;
import com.minimundo.desafio.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	private UsuarioRepository usuarioRepository;
	private PasswordEncoder passwordEncoder;
	
	public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
		this.usuarioRepository = usuarioRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public Usuario criarUsuario(Usuario usuario) {
		String pass = passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(pass);
		usuarioRepository.save(usuario);
		return usuario;
	}
	
	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}
	
	public Optional<Usuario> getUsuarioAutenticacao(String username) {
		return usuarioRepository.findByNome(username);
	}

	public Optional<Usuario> buscarUsuarioPorCodigo(Long codigoUsuario) {
		return usuarioRepository.findById(codigoUsuario);
	}

}
