package br.com.marcelo.forum.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.marcelo.forum.modelo.entity.StatusTopico;
import br.com.marcelo.forum.modelo.entity.Topico;

public class DetalhesDoTopicoDto {
	
	private Long id;
	private String title;
	private String mensagem;
	private LocalDateTime dataCriacao;
	private String nomeDoAutor;
	private StatusTopico status;
	private List<RespostaDto> respostas;
	
	public DetalhesDoTopicoDto(Topico topico){
		this.id = topico.getId();
		this.title = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
		this.nomeDoAutor = topico.getAutor().getNome();
		this.status = topico.getStatus();
		this.respostas = new ArrayList<RespostaDto>();
		this.respostas.addAll(topico.getRespostas().stream().map(RespostaDto::new).collect(Collectors.toList())); // dado uma resposta crie uma nova lista de respostaDto utilizando map
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

	public String getNomeDoAutor() {
		return nomeDoAutor;
	}

	public StatusTopico getStatus() {
		return status;
	}

	public List<RespostaDto> getRespostas() {
		return respostas;
	}

}
