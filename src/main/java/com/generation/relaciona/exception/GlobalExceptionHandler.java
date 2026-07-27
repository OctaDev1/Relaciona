package com.generation.relaciona.exception;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Intercepta erros gerados pelas anotações de validação (@NotBlank, @Size, @Positive, etc.)
	 * Retorna um JSON limpo mostrando apenas o campo que falhou e a mensagem de erro, onde se contra o ex -> é uma abreviação para Exception
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException exception) { // Mapa onde guarda chave (produto), valor(O Campo Produto é obrigatorio)
		Map<String, String> errors = new HashMap<>();
		
		// Pega o relatório da requisição, extrai todos os erros e percorre um por um
		exception.getBindingResult().getAllErrors().forEach((error) -> {
			
			// Descobre qual campo falhou e qual foi a mensagem definida na Model
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			
			// Guarda essas informações para devolver ao usuário
			errors.put(fieldName, errorMessage);
		});
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}

	/**
	 * Intercepta as exceções manuais que lançamos nas Controllers (ex: Cliente não existe)
	 * Retorna um JSON formatado em vez do erro padrão do servidor.
	 */
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<Map<String, String>> handleResponseStatusException(ResponseStatusException ex) {
		Map<String, String> error = new HashMap<>();
		error.put("erro", ex.getReason());
		
		return ResponseEntity.status(ex.getStatusCode()).body(error);
	}
}