package com.generation.relaciona.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

//Declarando uma entidade
@Entity
//Nome da tabela
@Table(name = "tb_oportunidade")


public class Oportunidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 50)
    @NotBlank
    private String titulo;

    @Size(min = 1, max = 50)
    @NotBlank
    private String status;


    @NotNull
    private BigDecimal valor;


    private LocalDate dataCriacao;

    //private LocalDate dataFechamento;

    //Constructor
    public Oportunidade(Long id, String titulo, String status, BigDecimal valor) {
        this.id = id;
        this.titulo = titulo;
        this.status = status;
        this.valor = valor;
        this.dataCriacao = LocalDate.now();
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }


    //Constructor vazio
    public Oportunidade() {
    }

    //Getters e Setters
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
