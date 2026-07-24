package com.generation.relaciona.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.relaciona.model.Cliente;

public interface ClienteRepository extends JpaRepository< Cliente, Long> {
	
	public List<Cliente> findAllByNomeCompletoContaining(String nome);

}
