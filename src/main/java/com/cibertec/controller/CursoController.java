package com.cibertec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entity.Curso;
import com.cibertec.service.CursoService;

@RestController
@RequestMapping("/rest/curso")
public class CursoController {

	@Autowired
	private CursoService service;
	
	@GetMapping()
	public ResponseEntity<?>  lista(){
		List<Curso> lstSalida = service.listaCurso();
		return ResponseEntity.ok(lstSalida);
	}
	@GetMapping("/porCategoria/{id}")
	public ResponseEntity<?>  listaPorCategoria(@PathVariable("id") int idCategoria){
		List<Curso> lstSalida = service.listaCursoPorCategoria(idCategoria);
		return ResponseEntity.ok(lstSalida);
	}
	@PostMapping
	public ResponseEntity<?>  inserta(@RequestBody Curso obj){
		Curso objSalida = service.insertaCurso(obj);
		return ResponseEntity.ok(objSalida);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?>  eliminaCurso(@PathVariable Integer id){
		service.eliminaCurso(id);
		Optional<Curso> optCurso = service.buscaCurso(id);
		if (optCurso.isEmpty()) {
			return ResponseEntity.ok("Eliminación exitosa");
		}
		return ResponseEntity.ok("No existe el id " + id);
	}
	
	@PutMapping
	public ResponseEntity<?> actualiza(@RequestBody Curso obj){
		Optional<Curso> optCurso = service.buscaCurso(obj.getIdCurso());
		if (optCurso.isPresent()) {
			Curso objSalida = service.insertaCurso(obj);
			return ResponseEntity.ok(objSalida);
		}else {
			return ResponseEntity.ok("El Curso no existe");
		}
	}
}






