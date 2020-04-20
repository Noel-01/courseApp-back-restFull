package com.byBatis.courses.repositoris;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.byBatis.courses.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

	Optional<Curso> findById(Long id);
}
