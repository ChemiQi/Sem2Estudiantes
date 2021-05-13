package com.example.Sem2Estudiantes.student.infraestructure.repository;

import com.example.Sem2Estudiantes.student.exceptions.NotFoundException;
import com.example.Sem2Estudiantes.student.infraestructure.repository.jpa.EstudianteRepository;
import com.example.Sem2Estudiantes.student.infraestructure.repository.port.DeleteEstudiantePort;
import org.springframework.beans.factory.annotation.Autowired;
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
