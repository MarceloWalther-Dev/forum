package br.com.marcelo.forum.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcelo.forum.dto.DetalhesDoTopicoDto;
import br.com.marcelo.forum.dto.TopicoDto;
import br.com.marcelo.forum.dto.form.AtualizacaoTopicoForm;
import br.com.marcelo.forum.dto.form.TopicoForm;
import br.com.marcelo.forum.modelo.entity.Topico;
import br.com.marcelo.forum.modelo.exception.EntidadeNaoEncontradaException;
import br.com.marcelo.forum.repository.CursoRepository;
import br.com.marcelo.forum.repository.TopicoRepository;
import br.com.marcelo.forum.service.TopicoService;

@Service
public class TopicoServiceImplements implements TopicoService{
	
	@Autowired
	TopicoRepository repository;
	
	@Autowired
	CursoRepository cursoRepository;

	@Override
	public List<TopicoDto> listAll() {
		
		List<Topico> topicos = repository.findAll();
		return TopicoDto.convertList(topicos);
	}

	@Override
	public List<TopicoDto> findByNomeCurso(String nomeCurso) {
		
		List<Topico> listaTopicoComFiltroNomeDoCurso = repository.findByCurso_Nome(nomeCurso);
		return TopicoDto.convertList(listaTopicoComFiltroNomeDoCurso);
	}

	@Override
	public TopicoDto cadastrarTopico(TopicoForm topicoForm) {
		
		Topico topico = topicoForm.convertTopico(cursoRepository);
		topico = repository.save(topico);
		return TopicoDto.convertToDto(topico);

	}

	@Override
	public DetalhesDoTopicoDto getOne(Long idTopico) {
		Topico topico = retornaTopicoSeNaoHouverJogaExceptionEntidadeNaoEncontrada(idTopico);
		
		return new DetalhesDoTopicoDto(topico);
	}


	@Override
	public TopicoDto atualizar(Long idTopico, AtualizacaoTopicoForm form) {

		Topico topico = retornaTopicoSeNaoHouverJogaExceptionEntidadeNaoEncontrada(idTopico);
		BeanUtils.copyProperties(form, topico);
		Topico topicoAtualizado = repository.save(topico);
		
		return TopicoDto.convertToDto(topicoAtualizado);
	}

	@Override
	public void remover(Long topicoId) {
		Topico topico = retornaTopicoSeNaoHouverJogaExceptionEntidadeNaoEncontrada(topicoId);
		repository.deleteById(topicoId);
	}
	
	
	private Topico retornaTopicoSeNaoHouverJogaExceptionEntidadeNaoEncontrada(Long idTopico) {
		Topico topico = repository.findById(idTopico).orElseThrow(()-> new EntidadeNaoEncontradaException(idTopico));
		return topico;
	}

	
	
	
	

}
