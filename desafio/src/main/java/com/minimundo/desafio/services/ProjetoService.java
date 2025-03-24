package com.minimundo.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.minimundo.desafio.entities.Projeto;
import com.minimundo.desafio.entities.Usuario;
import com.minimundo.desafio.entities.dtos.ProjetoDTO;
import com.minimundo.desafio.repositories.ProjetoRepository;

@Service
public class ProjetoService {
	
	private ProjetoRepository projetoRepository;
	private UsuarioService usuarioService;

	public ProjetoService(ProjetoRepository projetoRepository, UsuarioService usuarioService) {
		this.projetoRepository = projetoRepository;
		this.usuarioService = usuarioService;
	}
	
	public Projeto criarProjeto(ProjetoDTO projetoDTO) throws Exception {
		Projeto novoProjeto = new Projeto();
		novoProjeto.setNome(projetoDTO.getNome());
		novoProjeto.setDescricao(projetoDTO.getDescricao());
		novoProjeto.setStatus(projetoDTO.getStatus());
		novoProjeto.setOrcamento(projetoDTO.getOrcamento());
		
		Optional<Usuario> vincularUsuario = usuarioService.buscarUsuarioPorCodigo(projetoDTO.getIdUsuario());
		if (Optional.ofNullable(vincularUsuario).isPresent()) {
			novoProjeto.setUsuario(vincularUsuario.get());
			projetoRepository.save(novoProjeto);
		} else {
			throw new Exception("Usuário não encontrado");
		}
		return novoProjeto;
	}
	
	public Optional<Projeto> editarProjeto(ProjetoDTO projetoDTO) throws Exception {
		Optional<Projeto> projetoEditado = projetoRepository.findById(projetoDTO.getCodigo());
		projetoEditado.get().setNome(projetoDTO.getNome());
		projetoEditado.get().setDescricao(projetoDTO.getDescricao());
		projetoEditado.get().setStatus(projetoDTO.getStatus());
		projetoEditado.get().setOrcamento(projetoDTO.getOrcamento());
		
		Optional<Usuario> usuarioEditado = usuarioService.buscarUsuarioPorCodigo(projetoDTO.getIdUsuario());
		if (Optional.ofNullable(usuarioEditado).isPresent()) {
			projetoEditado.get().setUsuario(usuarioEditado.get());
			projetoRepository.save(projetoEditado.get());
		} else {
			throw new Exception("Usuário não encontrado");
		}
		return projetoEditado;
	}
	
	public List<Projeto> listarProjetos() {
		return projetoRepository.findAll();
	}
	
	public Optional<Projeto> buscarProjetoPorNome(String nome) {
		return projetoRepository.findByNome(nome);
	}
	
	public void excluirProjeto(String nome) throws Exception {
		Optional<Projeto> projetoVerificado = projetoRepository.findByNome(nome);
		if (Optional.ofNullable(projetoVerificado).isPresent() && projetoVerificado.get().getStatus() == "inativo") {
			projetoRepository.deleteByNome(nome);	
		} else {
			throw new Exception("Existem dependências que impedem a remoção deste projeto.");
		}
		
	}

}
