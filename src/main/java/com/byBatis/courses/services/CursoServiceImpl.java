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
				.map(curso -> CursoResponseDto.class.cast(modelMapper.map(curso, CursoResponseDto.class)))
				.collect(Collectors.toList());
	}

	@Override
	public CursoResponseDto save(CursoRequestDto request) {
		//cursoRepository.save(request);
		return null;
	}

	@Override
	public CursoResponseDto getById(Long request) {
		Optional<Curso> curso = cursoRepository.findById(request);
		if(curso.isPresent()){
			return modelMapper.map(curso.get(), CursoResponseDto.class);
		}
		return new CursoResponseDto();
	}

	@Override
	public CursoResponseDto update(CursoRequestDto request, Long cursoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long cursoId) {
		// TODO Auto-generated method stub
		
	}
	
}
