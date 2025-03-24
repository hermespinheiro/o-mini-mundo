package com.minimundo.desafio.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minimundo.desafio.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findByNome(String nome);

}
