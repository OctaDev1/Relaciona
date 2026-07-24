package com.generation.relaciona.controller;

import com.generation.relaciona.model.Oportunidade;
import com.generation.relaciona.repository.OportunidadeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/oportunidades")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class OportunidadeController {

    @Autowired
    private OportunidadeRepository oportunidadeRepository;

    //BUSCA TODOS
    @GetMapping
    public ResponseEntity<List<Oportunidade>> getAll(){
        return ResponseEntity.ok(oportunidadeRepository.findAll());
    }

    //BUSCA POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Oportunidade> getById(@PathVariable long id){
        Optional<Oportunidade> cliente = oportunidadeRepository.findById (id);
        if (cliente.isEmpty ())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok (cliente.get());
    }

    //BUSCA POR NOME
    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Oportunidade>> getAllByNome (@PathVariable String titulo){
        return ResponseEntity.ok (oportunidadeRepository.findByTituloContainingIgnoreCase (titulo));
    }

    //POST = INSERT
    @PostMapping
    public ResponseEntity<Oportunidade> post(@Valid @RequestBody Oportunidade oportunidade){
        return ResponseEntity.status (HttpStatus.CREATED)
                .body(oportunidadeRepository.save(oportunidade));
    }

    //PUT = UPDATE
    @PutMapping
    public ResponseEntity<Oportunidade>put(@Valid @RequestBody Oportunidade oportunidade){
        if (oportunidadeRepository.existsById (oportunidade.getId ()))
            return ResponseEntity.ok (oportunidadeRepository.save (oportunidade));
        return ResponseEntity.notFound ().build ();
    }


    //DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        Optional<Oportunidade> oportunidade = oportunidadeRepository.findById (id);
        if (oportunidade.isEmpty ())
            throw new ResponseStatusException (HttpStatus.NOT_FOUND);
        oportunidadeRepository.deleteById (id);
    }



}
