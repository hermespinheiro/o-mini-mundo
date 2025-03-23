package com.minimundo.desafio.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minimundo.desafio.entities.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

	Optional<Projeto> findByNome(String nome);

	void deleteByNome(String nome);

}
