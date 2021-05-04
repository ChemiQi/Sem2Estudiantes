package com.example.Sem2Estudiantes.infraestructure.repository.port;

import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoInput;
import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoOutput;
import org.springframework.http.ResponseEntity;

public interface AddEstudiantePort {
    ResponseEntity<EstudianteDtoOutput> añadirEstudiante(EstudianteDtoInput estudianteDtoInput);
}
