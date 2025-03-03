package com.aula.ProjetoTeste.Cursos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Cursomodel, UUID> {
Cursomodel findBynomecurso(String nomecurso);
} 
