package com.byBatis.courses.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byBatis.courses.dto.CursoRequestDto;
import com.byBatis.courses.dto.CursoResponseDto;
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

	@Override
	public CursoResponseDto save(CursoRequestDto request) {
		//cursoRepository.save(request);
		return null;
	}

	@Override
	public CursoResponseDto getById(Long request) {
		// TODO Auto-generated method stub
		return null;
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
