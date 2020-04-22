package com.byBatis.courses.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byBatis.courses.entities.Profesor;
import com.byBatis.courses.repositoris.ProfesorRepository;

@Service
public class ProfesorServiceImpl {

	@Autowired
	private ProfesorRepository profesorRepository;
	
	public List<Profesor> getAll() {
		return profesorRepository.findAll();
	}
	
	public Profesor save(Profesor profesor) {
		return profesorRepository.save(profesor);
	}

}
