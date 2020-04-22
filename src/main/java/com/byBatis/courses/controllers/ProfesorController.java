package com.byBatis.courses.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.byBatis.courses.entities.Profesor;
import com.byBatis.courses.services.ProfesorServiceImpl;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("profesores")
public class ProfesorController {
	
	@Autowired
	private ProfesorServiceImpl profesorService;

	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Profesor>> getAll(){
		return new ResponseEntity<List<Profesor>>(profesorService.getAll(), HttpStatus.OK);
	}
	
	@PostMapping(value="", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Profesor> save(@RequestBody Profesor profesor){
		return new ResponseEntity<Profesor>(profesorService.save(profesor), HttpStatus.OK);
	}
	
}
