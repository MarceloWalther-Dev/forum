package br.com.marcelo.forum.modelo.exception;

import org.springframework.context.i18n.LocaleContextHolder;

public class EntidadeNaoEncontradaException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	private String msg;
	
	public EntidadeNaoEncontradaException(Long number) {
		this.msg = String.format(
				LocaleContextHolder.getLocale(), 
				"Não foi possivel encontrar a entidade com o id %d",
				number
				);
	}

	public String getMsg() {
		return msg;
	}

}
