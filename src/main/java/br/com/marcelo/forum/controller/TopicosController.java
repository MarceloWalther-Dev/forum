package br.com.marcelo.forum.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.marcelo.forum.dto.DetalhesDoTopicoDto;
import br.com.marcelo.forum.dto.TopicoDto;
import br.com.marcelo.forum.dto.form.AtualizacaoTopicoForm;
import br.com.marcelo.forum.dto.form.TopicoForm;
import br.com.marcelo.forum.service.impl.TopicoServiceImplements;

@RestController
@RequestMapping("/topicos")
public class TopicosController {
	
	@Autowired
	TopicoServiceImplements service;
	
	@GetMapping 
	public List<TopicoDto> list(String nomeCurso){
		
		if(StringUtils.hasText(nomeCurso)) {
			return service.findByNomeCurso(nomeCurso);
		}else {
			return service.listAll();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoTopicoDto> detalhar(@PathVariable("id") Long idTopico) {	
		DetalhesDoTopicoDto dto = service.getOne(idTopico);
			return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm dto, UriComponentsBuilder uriBuilder){
		 
		TopicoDto topicoDto = service.cadastrarTopico(dto);
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topicoDto.getId()).toUri();
		return ResponseEntity.created(uri).body(topicoDto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TopicoDto> atualizar( @PathVariable("id") Long id, @RequestBody AtualizacaoTopicoForm form){
		
		TopicoDto topicoDto = service.atualizar(id, form);
		return ResponseEntity.ok().body(topicoDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable("id") Long idTopico){
		service.remover(idTopico);
		return ResponseEntity.noContent().build();
	}
	

	

}
