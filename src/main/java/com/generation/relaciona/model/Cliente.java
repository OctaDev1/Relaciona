package com.generation.relaciona.model;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O campo Nome Completo não pode ficar vazio!")
	@Size(min = 10, max = 255, message = "O Nome completo deve conter entre 10 a 255 caracteres!")
	@Column(name = "nomeCompleto", nullable = false)
	private String nomeCompleto;

	@Email
	@NotBlank(message = "O campo email não pode estar vazio!")
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@CPF
	@Pattern(
			regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", 
			message = "CPF deve estar no formato 000.000.000-00")
	private String cpf;

}
