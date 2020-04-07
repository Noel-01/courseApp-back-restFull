package com.byBatis.courses.services;

import java.util.List;

import com.byBatis.courses.dto.CursoRequestDto;
import com.byBatis.courses.dto.CursoResponseDto;


public interface ICursoService {

	public List<CursoResponseDto> getAll();
	public CursoResponseDto save(CursoRequestDto request);
	public CursoResponseDto getById(Long request);
	public CursoResponseDto update(CursoRequestDto request, Long cursoId);
	public void delete(Long cursoId);
}
