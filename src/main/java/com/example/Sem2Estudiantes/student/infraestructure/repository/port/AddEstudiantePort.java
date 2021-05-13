package com.example.Sem2Estudiantes.student.infraestructure.repository.port;

import com.example.Sem2Estudiantes.student.infraestructure.controller.dto.EstudianteDtoInput;
import com.example.Sem2Estudiantes.student.infraestructure.controller.dto.EstudianteDtoOutput;

public interface AddEstudiantePort {
    EstudianteDtoOutput añadirEstudiante(EstudianteDtoInput estudianteDtoInput) throws Exception;
}
