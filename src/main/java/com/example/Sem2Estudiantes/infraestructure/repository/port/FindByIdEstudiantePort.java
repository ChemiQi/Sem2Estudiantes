package com.example.Sem2Estudiantes.infraestructure.repository.port;

import com.example.Sem2Estudiantes.domain.EstudianteJpa;
import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoOutput;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface FindByIdEstudiantePort {
    EstudianteDtoOutput findByIdEstudiante(String id) throws Exception;
}
