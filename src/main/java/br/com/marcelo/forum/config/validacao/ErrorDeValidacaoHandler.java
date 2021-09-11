package br.com.marcelo.forum.config.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.marcelo.forum.config.validacao.errorDto.ErrorDto;
import br.com.marcelo.forum.modelo.exception.EntidadeNaoEncontradaException;

@RestControllerAdvice
public class ErrorDeValidacaoHandler {
	
	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErrorDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
		
		List<ErrorDto> dto = new ArrayList<ErrorDto>();
		
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(e ->{
			String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErrorDto error = new ErrorDto(e.getField(), message);
			dto.add(error);
		});
		
		return dto;
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ErrorDto handleEntidadeNaoEncontrada(EntidadeNaoEncontradaException exception) {

		ErrorDto errorDto = new ErrorDto(exception.getMsg());
		return errorDto;
	}
	
}
