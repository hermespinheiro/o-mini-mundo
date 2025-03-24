package com.minimundo.desafio.entities.dtos;

import com.minimundo.desafio.entities.Usuario;

public class ProjetoDTO {
	
	private Long codigo;
	private String nome;
	private String descricao;
	private String status;
	private float orcamento;
	private Long idUsuario;
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public float getOrcamento() {
		return orcamento;
	}
	
	public void setOrcamento(float orcamento) {
		this.orcamento = orcamento;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

}
