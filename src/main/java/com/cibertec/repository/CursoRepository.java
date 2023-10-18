package com.cibertec.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cibertec.entity.Curso;

public interface CursoRepository extends MongoRepository<Curso, Integer>{

	@Query("{categoria: ?0}")
	public List<Curso> listaCursoPorCategoria(int idCategoria);
}
