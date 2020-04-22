package com.byBatis.courses.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byBatis.courses.dto.CursoRequestDto;
import com.byBatis.courses.dto.CursoResponseDto;
import com.byBatis.courses.entities.Curso;
import com.byBatis.courses.repositoris.CursoRepository;

@Service
public class CursoServiceImpl implements ICursoService {

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<CursoResponseDto> getAll() {
		return cursoRepository.findAll().stream()
				.map(curso -> modelMapper.map(curso, CursoResponseDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public CursoResponseDto save(CursoRequestDto request) {
		
		Curso curso = modelMapper.map(request, Curso.class);
		
		if(curso.getId() == null) {
			return modelMapper.map((cursoRepository.save(curso)), CursoResponseDto.class);
		} else {
			throw new RuntimeException("El curso ya existe");
		}
	}

	@Override
	public CursoResponseDto getById(Long request) {
		
		Optional<Curso> curso = cursoRepository.findById(request);
		
		if (curso.isPresent()) {
			return modelMapper.map(curso.get(), CursoResponseDto.class);
		}
		return new CursoResponseDto();
	}

	@Override
	public CursoResponseDto update(CursoRequestDto request, Long cursoId) {
		
		Optional<Curso> curso = cursoRepository.findById(cursoId);
		Curso cursoGuardado;
		
		if(curso.isPresent()) {
			cursoGuardado = cursoRepository.save(modelMapper.map(request, Curso.class));
		} else {
			throw new RuntimeException("El curso no existe");
		}
		return modelMapper.map(cursoGuardado, CursoResponseDto.class);
	}

	@Override
	public void delete(Long cursoId) {
		Optional<Curso> curso = cursoRepository.findById(cursoId);
		
		if(curso.isPresent()) {
			cursoRepository.deleteById(cursoId);
		} else {
			throw new RuntimeException("El curso no existe");
		}

	}

}
