package com.byBatis.courses.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@ToString(exclude = "cursos")
//@EqualsAndHashCode(exclude = "cursos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "profesores")
public class Profesor {

	@Id
	@Column(name = "profesor_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre")
	private String nombreProfesor;
	
	// Esto funciona porque estoy utilizando los DTO para los mapeos si no hay que ver 
	// como hacer para que no de recursividad infinita (stack over flow)
//	@OneToMany(mappedBy="profesor", cascade = CascadeType.ALL)
//	private Set<Curso> cursos = new HashSet<>();
}
