package com.byBatis.courses.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.byBatis.courses.entities.Profesor;
import com.byBatis.courses.repositoris.ProfesorRepository;

@Service
public class ProfesorServiceImpl {

	private ProfesorRepository profesorRepository;
	
	public List<Profesor> getAll() {
		return profesorRepository.findAll();
	}
	
	

}
