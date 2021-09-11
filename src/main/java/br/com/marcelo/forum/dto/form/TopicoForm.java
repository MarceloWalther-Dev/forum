package br.com.marcelo.forum.dto.form;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import br.com.marcelo.forum.modelo.entity.Curso;
import br.com.marcelo.forum.modelo.entity.Topico;
import br.com.marcelo.forum.repository.CursoRepository;

public class TopicoForm {

	@NotNull
	private String titulo;
	
	@NotBlank
	private String mensagem;
	
	@NotBlank
	private String nomeCurso;
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String getNomeCurso() {
		return nomeCurso;
	}
	
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
	public Topico convertTopico(CursoRepository cursoRepository) {
		Curso curso = cursoRepository.findByNome(nomeCurso);
		return new Topico(titulo, mensagem, curso);
	}
}
