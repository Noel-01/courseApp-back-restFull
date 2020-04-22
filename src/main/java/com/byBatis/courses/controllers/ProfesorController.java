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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.byBatis.courses.dto.ProfesorRequestDto;
import com.byBatis.courses.dto.ProfesorResponseDto;
import com.byBatis.courses.services.IProfesorService;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("profesores")
public class ProfesorController {
	

	@Autowired
	private IProfesorService profesorService;

	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProfesorResponseDto>> getAll(){
		return new ResponseEntity<List<ProfesorResponseDto>>(profesorService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/obtener/{profesorId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProfesorResponseDto> getById(
			@PathVariable Long profesorId){
		return new ResponseEntity<ProfesorResponseDto>(profesorService.getById(profesorId), HttpStatus.OK);
	}
	
	@PostMapping(value="", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProfesorResponseDto> save(
			@RequestBody ProfesorRequestDto profesor){
		return new ResponseEntity<ProfesorResponseDto>(profesorService.save(profesor), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/borrar/{profesorId}")
	public ResponseEntity<?> delete(@PathVariable Long profesorId){
		profesorService.delete(profesorId);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
}
