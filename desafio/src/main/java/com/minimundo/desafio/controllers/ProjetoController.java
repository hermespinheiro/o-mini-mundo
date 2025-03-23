package com.minimundo.desafio.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minimundo.desafio.entities.Projeto;
import com.minimundo.desafio.entities.dtos.ProjetoDTO;
import com.minimundo.desafio.services.ProjetoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/projeto")
@Tag(name = "projeto")
public class ProjetoController {

	private ProjetoService projetoService;

	public ProjetoController(ProjetoService projetoService) {
		this.projetoService = projetoService;
	}
	
	@Operation(summary = "Adiciona um novo projeto")
	@PostMapping("/adicionar")
	public ResponseEntity<?> criarProjeto(@RequestBody ProjetoDTO projetoDTO) {
		try {
			Projeto projetoCriado = projetoService.criarProjeto(projetoDTO);
			return ResponseEntity.ok(projetoCriado);
		} catch (Exception e) {
			if (e.getMessage().equals("Usuário não encontrado")) {
	            return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(400));
	        }
			return new ResponseEntity("Erro de Consulta", HttpStatusCode.valueOf(504));
		}
	}
	
	@Operation(summary = "Busca um projeto pelo nome")
	@GetMapping("/buscar/{nome}")
	public ResponseEntity<?> buscarProjetoPorNome(@PathVariable String nome) {
		try {
			Optional<Projeto> projeto = projetoService.buscarProjetoPorNome(nome);
			return ResponseEntity.ok(projeto);
		} catch (Exception e) {
			return new ResponseEntity("Erro de Consulta", HttpStatusCode.valueOf(504));
		}
	}
	
	@Operation(summary = "Busca todos os projetos")
	@GetMapping("/buscar")
	public ResponseEntity<?> listarProjetos() {
		try {
			List<Projeto> projeto = projetoService.listarProjetos();
			return ResponseEntity.ok(projeto);
		} catch (Exception e) {
			return new ResponseEntity("Erro de Consulta", HttpStatusCode.valueOf(504));
		}
	}
	
	@Operation(summary = "Edita um projeto")
	@PatchMapping("/editar")
	public ResponseEntity<?> editarProjeto(@RequestBody ProjetoDTO projetoDTO) {
		try {
			Optional<Projeto> projetoEditado = projetoService.editarProjeto(projetoDTO);
			return ResponseEntity.ok(projetoEditado);
		} catch (Exception e) {
			return new ResponseEntity("Erro de Consulta", HttpStatusCode.valueOf(504));
		}
	}

	@Operation(summary = "Deleta um projeto pelo nome")
	@DeleteMapping("/editar/{nome}")
	public ResponseEntity<?> excluirProjeto(@PathVariable String nome) {
		try {
			projetoService.excluirProjeto(nome);
			return ResponseEntity.ok("Excluído com sucesso");
		} catch (Exception e) {
			return new ResponseEntity("Erro de Consulta", HttpStatusCode.valueOf(504));
		}
	}
	
}
