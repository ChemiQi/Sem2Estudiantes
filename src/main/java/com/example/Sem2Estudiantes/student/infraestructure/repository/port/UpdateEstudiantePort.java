package com.example.Sem2Estudiantes.student.infraestructure.repository.port;

import com.example.Sem2Estudiantes.student.infraestructure.controller.dto.EstudianteDtoInput;

public interface UpdateEstudiantePort {
    void actualizarEstudiante(String id,EstudianteDtoInput estudianteDtoInput) throws Exception;
}
