package com.byBatis.courses.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byBatis.courses.dto.CursoResponseDto;
import com.byBatis.courses.repositoris.CursoRepository;



@Service
public class CursoServiceImpl {

	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<CursoResponseDto> getAll() {
		 return cursoRepository.findAll().stream()
				.map(curso -> CursoResponseDto.class.cast(modelMapper.map(curso, CursoResponseDto.class)))
				.collect(Collectors.toList());
		
//		List<Curso> cursoList =  cursoRepository.findAll();
//		List<CursoResponseDto> cursoRespDto = new ArrayList<>();
//		
//		for(Curso cdto: cursoList) {
//			CursoResponseDto c = new CursoResponseDto();
//			c.setLevel(cdto.getLevel());
//			c.setNumberOfHours(cdto.getNumberOfHours());
//			c.setProfesor(cdto.getProfesor().getNombre());
//			c.setState(cdto.getState());
//			c.setTitle(cdto.getTitle());
//			cursoRespDto.add(c);
//		}
		
	//	return cursoRespDto;
	}
	
}
