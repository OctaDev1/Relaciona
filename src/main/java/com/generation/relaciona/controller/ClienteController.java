package com.generation.relaciona.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.relaciona.model.Cliente;
import com.generation.relaciona.model.Cliente.TipoPessoa;
import com.generation.relaciona.repository.ClienteRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public ResponseEntity<List<Cliente>> getAll() {
		return ResponseEntity.ok(clienteRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getById(@PathVariable Long id) {
	    return clienteRepository.findById(id)
	            .map(ResponseEntity::ok)
	            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Cliente>> getByNomeCompleto(@PathVariable String nome) {
		return ResponseEntity.ok(clienteRepository.findAllByNomeCompletoContaining(nome));

	}

	@PostMapping
	public ResponseEntity<Cliente> post(@Valid @RequestBody Cliente cliente) {

		if (cliente.getTipoPessoa() == TipoPessoa.Fisica) {

			if (cliente.getCpf() == null || cliente.getCpf().isBlank()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pessoa Física deve possuir um CPF válido!");
			}

		}

		if (cliente.getTipoPessoa() == TipoPessoa.Juridica) {

			if (cliente.getCnpj() == null || cliente.getCnpj().isBlank()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
						"Pessoa Júridica deve possuir um CNPJ válido!");
			}

		}

		return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(cliente));
	}

	@PutMapping
	public ResponseEntity<Cliente> put(@Valid @RequestBody Cliente cliente) {
		if (clienteRepository.existsById(cliente.getId()))
			return ResponseEntity.ok(clienteRepository.save(cliente));
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID informado não existe, por favor insira um id valido!");
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@Valid @PathVariable Long id) {
		Optional<Cliente> postagem = clienteRepository.findById(id);
		if (postagem.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente Não Encontrado!");

		clienteRepository.deleteById(id);
	}

}
