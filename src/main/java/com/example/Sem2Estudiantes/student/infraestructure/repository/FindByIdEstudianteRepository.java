package com.example.Sem2Estudiantes.student.infraestructure.repository;

import com.example.Sem2Estudiantes.student.exceptions.NotFoundException;
import com.example.Sem2Estudiantes.student.infraestructure.controller.dto.EstudianteDtoOutput;
import com.example.Sem2Estudiantes.student.infraestructure.repository.jpa.EstudianteRepository;
import com.example.Sem2Estudiantes.student.infraestructure.repository.port.FindByIdEstudiantePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FindByIdEstudianteRepository implements FindByIdEstudiantePort {

    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public EstudianteDtoOutput findByIdEstudiante(String id) throws Exception {
        return new EstudianteDtoOutput(estudianteRepository.findById(id).orElseThrow(() -> new NotFoundException()));
    }


    
}
