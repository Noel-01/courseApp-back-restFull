package com.byBatis.courses.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.byBatis.courses.dto.CursoRequestDto;
import com.byBatis.courses.dto.CursoResponseDto;
import com.byBatis.courses.services.ICursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private ICursoService cursoService;
	
	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CursoResponseDto> save(
			@RequestBody CursoRequestDto request){
		return new ResponseEntity<CursoResponseDto>(cursoService.save(request), HttpStatus.CREATED);
	}

	@GetMapping(value = "/obtener", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CursoResponseDto>> getAll(){
		return new ResponseEntity<List<CursoResponseDto>>(cursoService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/obtener/{cursoId}",  produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<CursoResponseDto> getById(
			@RequestParam Long cursoId){
		return new ResponseEntity<CursoResponseDto>(cursoService.getById(cursoId), HttpStatus.OK);
	}
	
	@PutMapping(value = "/modificar/{cursoId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CursoResponseDto> update(
			@RequestParam Long cursoId,
			@RequestBody CursoRequestDto request){
		return new ResponseEntity<CursoResponseDto>(cursoService.update(request, cursoId), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(
			@RequestParam Long cursoId){
		cursoService.delete(cursoId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
		
	
	
}
