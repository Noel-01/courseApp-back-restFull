package com.byBatis.courses.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byBatis.courses.dto.ProfesorRequestDto;
import com.byBatis.courses.dto.ProfesorResponseDto;
import com.byBatis.courses.entities.Profesor;
import com.byBatis.courses.repositoris.ProfesorRepository;

@Service
public class ProfesorServiceImpl {

	@Autowired
	private ProfesorRepository profesorRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<ProfesorResponseDto> getAll() {
		return profesorRepository.findAll().stream()
				.map(profesor -> modelMapper.map(profesor, ProfesorResponseDto.class))
				.collect(Collectors.toList());

	}
	
	public ProfesorResponseDto save(ProfesorRequestDto request) {
		Profesor profesor = modelMapper.map(request, Profesor.class);		
		return modelMapper.map(profesorRepository.save(profesor), ProfesorResponseDto.class);
	}

	public void delete(Long profesorId) {
		profesorRepository.deleteById(profesorId);
	}
}
