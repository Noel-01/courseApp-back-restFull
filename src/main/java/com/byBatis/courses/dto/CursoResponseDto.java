package com.byBatis.courses.dto;

import com.byBatis.courses.entities.Profesor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CursoResponseDto {

	private Long id;
	
	private String title;
	
	private String level;
	
	private int numberOfHours;
	
	private Boolean state;
	
	private Profesor nombreProfesor;
}
