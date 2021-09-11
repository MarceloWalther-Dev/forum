package br.com.marcelo.forum.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.marcelo.forum.modelo.entity.Topico;

public class TopicoDto {
	
	private Long id;
	private String title;
	private String mensagem;
	private LocalDateTime dataCriacao;
	
	public TopicoDto(Topico topico){
		this.id = topico.getId();
		this.title = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
	}
	
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getMensagem() {
		return mensagem;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public static List<TopicoDto> convertList(List<Topico> listDto) {
		return listDto.stream().map(TopicoDto::new).collect(Collectors.toList());
		
	}

	public static TopicoDto convertToDto(Topico topico) {
		return new TopicoDto(topico);
	}
	
	
}
