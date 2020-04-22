package com.byBatis.courses.services;

import java.util.List;

import com.byBatis.courses.dto.ProfesorRequestDto;
import com.byBatis.courses.dto.ProfesorResponseDto;

public interface IProfesorService {

	public List<ProfesorResponseDto> getAll();
	public ProfesorResponseDto save(ProfesorRequestDto request);
	public void delete(Long profesorId);
	public ProfesorResponseDto getById(Long profesorId);
}
