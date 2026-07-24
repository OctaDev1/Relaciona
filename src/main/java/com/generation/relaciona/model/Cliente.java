package com.generation.relaciona.model;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O campo Nome Completo não pode ficar vazio!")
	@Size(min = 10, max = 150, message = "O Nome completo deve conter entre 10 a 150 caracteres!")
	@Column(name = "nomeCompleto", nullable = false, length = 100)
	private String nomeCompleto;

	@Email
	@NotBlank(message = "O campo email não pode estar vazio!")
	@Size(min = 5, max = 255, message = "O e-mail deve ter entre 5 e 255 caracteres.")
	private String email;

	@NotBlank(message = "O campo CPF não pode ficar vazio!")
	@CPF
	@Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF deve estar no formato 000.000.000-00")
	private String cpf;
	
	@CNPJ(message = "O CNPJ informado é inválido!")
	@Column(name = "cnpj", nullable = true)
	private String cnpj;
	
	@NotBlank(message = "O campo Tipo de Pessoa não pode ficar vazio! Escolha entre Pessoa Física ou Juridica")
	@Column(name = "tipoPessoa")
	private String tipoPessoa;
	
	@NotNull(message = "O campo data de Nascimento não pode ficar vazio! Escreva no formato YYYY-MM-DD")
	@Column(name = "dataNascimento")
	private LocalDate dataNascimento; 

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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	

}
