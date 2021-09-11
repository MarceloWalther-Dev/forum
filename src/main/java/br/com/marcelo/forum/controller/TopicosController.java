package br.com.marcelo.forum.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.marcelo.forum.dto.TopicoDto;
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
	
	@PostMapping
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm dto, UriComponentsBuilder uriBuilder){
		 
		TopicoDto topicoDto = service.cadastrarTopico(dto);
		 
		 
		 URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topicoDto.getId()).toUri();
		 return ResponseEntity.created(uri).body(topicoDto);
		 
	}

	

}
