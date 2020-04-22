package com.byBatis.courses.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byBatis.courses.dto.ProfesorRequestDto;
import com.byBatis.courses.dto.ProfesorResponseDto;
import com.byBatis.courses.entities.Profesor;
import com.byBatis.courses.repositoris.ProfesorRepository;

@Service
public class ProfesorServiceImpl implements IProfesorService{

	@Autowired
	private ProfesorRepository profesorRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public List<ProfesorResponseDto> getAll() {
		return profesorRepository.findAll().stream()
				.map(profesor -> modelMapper.map(profesor, ProfesorResponseDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public ProfesorResponseDto save(ProfesorRequestDto request) {
		Profesor profesor = modelMapper.map(request, Profesor.class);		
		return modelMapper.map(profesorRepository.save(profesor), ProfesorResponseDto.class);
	}

	@Override
	public void delete(Long profesorId) {
		profesorRepository.deleteById(profesorId);
	}

	@Override
	public ProfesorResponseDto getById(Long profesorId) {
		Optional<Profesor> profesor = profesorRepository.findById(profesorId);
		if(profesor != null) {
			return modelMapper.map(profesor, ProfesorResponseDto.class);
		} else {
			throw new RuntimeException("El profesor no exixte");
		}
		
	}
}
