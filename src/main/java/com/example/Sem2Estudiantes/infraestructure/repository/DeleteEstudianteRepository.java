package com.example.Sem2Estudiantes.infraestructure.repository;

import com.example.Sem2Estudiantes.domain.EstudianteJpa;
import com.example.Sem2Estudiantes.exceptions.NotFoundException;
import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoOutput;
import com.example.Sem2Estudiantes.infraestructure.repository.jpa.EstudianteRepository;
import com.example.Sem2Estudiantes.infraestructure.repository.port.DeleteEstudiantePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class DeleteEstudianteRepository implements DeleteEstudiantePort {

    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public void borrarEstudiante(String id) throws Exception{
        estudianteRepository.delete(estudianteRepository.findById(id).orElseThrow(() -> new NotFoundException()));
    }
}
