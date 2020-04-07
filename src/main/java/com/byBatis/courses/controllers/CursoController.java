package com.byBatis.courses.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.byBatis.courses.dto.CursoResponseDto;
import com.byBatis.courses.services.CursoServiceImpl;

@RestController
@RequestMapping("rest/course")

public class CursoController {

	@Autowired
	private CursoServiceImpl cursoService;

	@GetMapping(value = "/activeCourses", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CursoResponseDto>> getAll(){
		return new ResponseEntity<List<CursoResponseDto>>(cursoService.getAll(), HttpStatus.OK);
	}
	
}
