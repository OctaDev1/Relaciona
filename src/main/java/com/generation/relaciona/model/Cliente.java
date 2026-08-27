package com.generation.relaciona.model;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_cliente")
public class Cliente {
	
	public enum TipoPessoa{
		Fisica,
		Juridica
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O campo Nome Completo não pode ficar vazio!")
	@Size(min = 10, max = 150, message = "O Nome completo deve conter entre 10 a 150 caracteres!")
	@Column(name = "nomeCompleto", nullable = false, length = 150)
	private String nomeCompleto;

	@Email
	@NotBlank(message = "O campo email não pode estar vazio!")
	@Size(min = 5, max = 255, message = "O e-mail deve ter entre 5 e 255 caracteres.")
	@Column(name = "email" ,unique = true)
	private String email;

	@CPF
	@Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF deve estar no formato 000.000.000-00")
	@Column(name = "cpf", unique = true, nullable = true)
	private String cpf;

	@CNPJ(message = "CNPJ informado é invalido")
	@Pattern(regexp = "\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}", message = "CNPJ deve estar no formato 00.000.000/0000-00")
	@Column(name = "cnpj", nullable = true, unique = true)
	private String cnpj;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "O tipo de pessoa é obrigatório! Escolha entre física e juridica!")
	@Column(name = "tipoPessoa")
	private TipoPessoa tipoPessoa;

	@NotNull(message = "O campo data de Nascimento não pode ficar vazio! Escreva no formato YYYY-MM-DD")
	@Column(name = "dataNascimento")
	private LocalDate dataNascimento;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.REMOVE)

	@JsonIgnoreProperties(value = "clientes", allowSetters = true)
	@Schema(hidden = true)
	private List<Oportunidade> oportunidades;

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


	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Oportunidade> getOportunidades() {
		return oportunidades;
	}

	public void setOportunidades(List<Oportunidade> oportunidades) {
		this.oportunidades = oportunidades;
	}

}
