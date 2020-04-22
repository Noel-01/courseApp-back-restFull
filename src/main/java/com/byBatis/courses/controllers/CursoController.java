package com.byBatis.courses.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.byBatis.courses.dto.CursoRequestDto;
import com.byBatis.courses.dto.CursoResponseDto;
import com.byBatis.courses.services.ICursoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private ICursoService cursoService;
	
	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Guardar")
	public ResponseEntity<CursoResponseDto> save(
			@RequestBody CursoRequestDto request){
		return new ResponseEntity<CursoResponseDto>(cursoService.save(request), HttpStatus.CREATED);
	}

	@GetMapping(value = "/obtener", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Obtener")
	public ResponseEntity<List<CursoResponseDto>> getAll(){
		return new ResponseEntity<List<CursoResponseDto>>(cursoService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/obtener/{cursoId}",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Obtener un curso")
	public ResponseEntity<CursoResponseDto> getById(
			@PathVariable Long cursoId){
		return new ResponseEntity<CursoResponseDto>(cursoService.getById(cursoId), HttpStatus.OK);
	}
	
	@PutMapping(value = "/modificar/{cursoId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Modificar un curso")
	public ResponseEntity<CursoResponseDto> update(
			@PathVariable Long cursoId,
			@RequestBody CursoRequestDto request){
		return new ResponseEntity<CursoResponseDto>(cursoService.update(request, cursoId), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "borrar/{cursoId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Borrar un curso")
	public ResponseEntity<?> delete(
			@PathVariable Long cursoId){
		cursoService.delete(cursoId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
		
	
	
}
