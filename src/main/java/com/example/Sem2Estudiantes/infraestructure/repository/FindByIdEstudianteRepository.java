package com.example.Sem2Estudiantes.infraestructure.repository;

import com.example.Sem2Estudiantes.domain.EstudianteJpa;
import com.example.Sem2Estudiantes.exceptions.NotFoundException;
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
    public EstudianteDtoOutput findByIdEstudiante(String id) throws Exception {
        return new EstudianteDtoOutput(estudianteRepository.findById(id).orElseThrow(() -> new NotFoundException()));
    }


    
}
