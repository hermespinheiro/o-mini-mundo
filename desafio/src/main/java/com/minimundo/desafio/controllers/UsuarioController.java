package com.minimundo.desafio.controllers;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minimundo.desafio.entities.Usuario;
import com.minimundo.desafio.services.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/usuario")
@Tag(name = "usuario")
public class UsuarioController {
	
	private UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@Operation(summary = "Adiciona um novo usuário")
	@PostMapping("/adicionar")
	public ResponseEntity<?> criarUsuario(@RequestBody Usuario usuario) {
		try {
			Usuario usuarioCriado = usuarioService.criarUsuario(usuario);
			return ResponseEntity.ok(usuarioCriado);
		} catch (Exception e) {
			return new ResponseEntity("Erro de Consulta", HttpStatusCode.valueOf(504));
		}
	}
	
	@Operation(summary = "Retorna todos os usuários")
	@GetMapping("/buscar")
	public ResponseEntity<?> listarUsuarios() {
		try {
			List<Usuario> usuarios = usuarioService.listarUsuarios();
			return ResponseEntity.ok(usuarios);
		} catch (Exception e) {
			return new ResponseEntity("Erro de Consulta", HttpStatusCode.valueOf(504));
		}
	}
}
