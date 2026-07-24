package com.generation.relaciona.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<List<Cliente>> getAll() {
		return ResponseEntity.ok(clienteRepository.findAll());
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Long id ){
        return clienteRepository.findById (id)
                .map (resposta -> ResponseEntity.ok (resposta))
                .orElse (ResponseEntity.notFound ().build ());
    }

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Cliente>> getByNomeCompleto(@PathVariable String nome) {
		return ResponseEntity.ok(clienteRepository.findAllByNomeCompletoContaining(nome));
	}
	
	@PostMapping
    public ResponseEntity<Cliente>post(@RequestBody Cliente cliente){
        return ResponseEntity.status (HttpStatus.CREATED)
                .body(clienteRepository.save(cliente));
    }
	
	 @PutMapping
	    public ResponseEntity<Cliente>put(@RequestBody Cliente cliente){
	        if (clienteRepository.existsById (cliente.getId ()))
	            return ResponseEntity.ok (clienteRepository.save (cliente));
	        return ResponseEntity.notFound ().build ();
	    }

}
