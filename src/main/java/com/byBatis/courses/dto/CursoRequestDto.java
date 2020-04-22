package com.byBatis.courses.dto;

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
public class CursoRequestDto {
	
	private String title;
	
	private String level;
	
	private int numberOfHours;
	
	private Boolean state;
	
	private ProfesorRequestDto profesor;
}
