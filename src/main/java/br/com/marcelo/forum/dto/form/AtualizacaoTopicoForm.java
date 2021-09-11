package br.com.marcelo.forum.dto.form;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

public class AtualizacaoTopicoForm {
	
	@NotNull
	private String titulo;
	
	@NotBlank
	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
