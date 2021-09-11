package br.com.marcelo.forum.config.validacao.errorDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class ErrorDto {
	
	private String campo;
	private String erro;
	
	public ErrorDto(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}
	
	public ErrorDto(String erro) {
		this.erro = erro;
	}
	

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
}
