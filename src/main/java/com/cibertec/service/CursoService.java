package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.entity.Curso;

public interface CursoService {

	public List<Curso> listaCurso();
	public List<Curso> listaCursoPorCategoria(int idCategoria);
	public Curso insertaCurso(Curso obj);
	public Optional<Curso> buscaCurso(int idCurso);
	public void eliminaCurso(int idCurso);
	
}
