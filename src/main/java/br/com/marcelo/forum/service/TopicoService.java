package br.com.marcelo.forum.service;

import java.util.List;

import br.com.marcelo.forum.dto.TopicoDto;
import br.com.marcelo.forum.dto.form.TopicoForm;

public interface TopicoService {
	
	public List<TopicoDto> listAll();
	
	public List<TopicoDto> findByNomeCurso(String nomeCurso);
	
	public TopicoDto cadastrarTopico(TopicoForm topicoForm);

}
