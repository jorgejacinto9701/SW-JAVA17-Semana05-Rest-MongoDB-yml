package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Curso;
import com.cibertec.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepository repository;

	@Override
	public List<Curso> listaCurso() {
		return repository.findAll();
	}

	@Override
	public Curso insertaCurso(Curso obj) {
		return repository.save(obj);
	}

	@Override
	public Optional<Curso> buscaCurso(int idCurso) {
		return repository.findById(idCurso);
	}

	@Override
	public void eliminaCurso(int idCurso) {
		repository.deleteById(idCurso);
	}

	@Override
	public List<Curso> listaCursoPorCategoria(int idCategoria) {
		return repository.listaCursoPorCategoria(idCategoria);
	}

}


