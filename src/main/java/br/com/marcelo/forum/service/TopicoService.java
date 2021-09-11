package br.com.marcelo.forum.service;

import java.util.List;

import br.com.marcelo.forum.dto.DetalhesDoTopicoDto;
import br.com.marcelo.forum.dto.TopicoDto;
import br.com.marcelo.forum.dto.form.AtualizacaoTopicoForm;
import br.com.marcelo.forum.dto.form.TopicoForm;

public interface TopicoService {
	
	public List<TopicoDto> listAll();
	
	public List<TopicoDto> findByNomeCurso(String nomeCurso);
	
	public TopicoDto cadastrarTopico(TopicoForm topicoForm);
	
	public DetalhesDoTopicoDto getOne(Long idTopico);
	
	public TopicoDto atualizar(Long idTopico, AtualizacaoTopicoForm form);
	
	public void remover(Long topicoId);

}
