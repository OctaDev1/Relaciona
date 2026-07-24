package com.generation.relaciona.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.relaciona.model.Cliente;
import com.generation.relaciona.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	 @GetMapping
	    public ResponseEntity<List<Cliente>> getAll(){
	        return ResponseEntity.ok (clienteRepository.findAll ());
	    }

}
