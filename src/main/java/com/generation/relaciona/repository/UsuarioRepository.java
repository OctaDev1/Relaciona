package com.generation.relaciona.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.relaciona.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);
	public List<Usuario> findAllByEmailContainingIgnoreCase(String email);
}