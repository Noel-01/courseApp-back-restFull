package com.byBatis.courses.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@ToString(exclude = "profesor")
//@EqualsAndHashCode(exclude = "profesor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cursos")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="curso_id")
	private Long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="level")
	private String level;
	
	@Column(name="numberOfHours")
	private int numberOfHours;
	
	@Column(name="state")
	private Boolean state;
	
	@ManyToOne
	@JoinColumn(name="profesor_id")
	private Profesor profesor;
	
}
