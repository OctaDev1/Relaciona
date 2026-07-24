package com.generation.relaciona.repository;
import com.generation.relaciona.model.Oportunidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OportunidadeRepository extends JpaRepository<Oportunidade, Long> {

    public List<Oportunidade> findByTituloContainingIgnoreCase(String titulo);

}
