package com.example.Sem2Estudiantes.infraestructure.repository.port;

import com.example.Sem2Estudiantes.domain.EstudianteJpa;

import java.util.Optional;

public interface FindByIdEstudiantePort {
    Optional<EstudianteJpa> findByIdEstudiante(Integer id);
}
