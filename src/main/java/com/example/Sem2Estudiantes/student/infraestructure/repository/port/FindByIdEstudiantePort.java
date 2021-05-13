package com.example.Sem2Estudiantes.student.infraestructure.repository.port;

import com.example.Sem2Estudiantes.student.infraestructure.controller.dto.EstudianteDtoOutput;

public interface FindByIdEstudiantePort {
    EstudianteDtoOutput findByIdEstudiante(String id) throws Exception;
}
