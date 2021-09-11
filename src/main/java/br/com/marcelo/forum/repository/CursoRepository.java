package br.com.marcelo.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marcelo.forum.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
	
	public Curso findByNome(String nomeCurso);

}
