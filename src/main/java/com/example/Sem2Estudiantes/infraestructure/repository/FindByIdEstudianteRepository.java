package com.example.Sem2Estudiantes.infraestructure.repository;

import com.example.Sem2Estudiantes.domain.EstudianteJpa;
import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoOutput;
import com.example.Sem2Estudiantes.infraestructure.repository.jpa.EstudianteRepository;
import com.example.Sem2Estudiantes.infraestructure.repository.port.FindByIdEstudiantePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class FindByIdEstudianteRepository implements FindByIdEstudiantePort {

    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public ResponseEntity<EstudianteDtoOutput> findByIdEstudiante(String id) {
            return obtenerEstudianteDtoOutputByIdEstudiante(id);
    }

    private ResponseEntity<EstudianteDtoOutput> obtenerEstudianteDtoOutputByIdEstudiante(String id) {
        Optional<EstudianteJpa> estudianteJpaOptional = estudianteRepository.findById(id);
        if(estudianteJpaOptional.isPresent()){
            return ResponseEntity.ok(new EstudianteDtoOutput(estudianteJpaOptional.get()));
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
}
