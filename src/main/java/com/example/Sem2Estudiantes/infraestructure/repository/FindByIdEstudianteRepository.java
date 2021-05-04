package com.example.Sem2Estudiantes.infraestructure.repository;

import com.example.Sem2Estudiantes.domain.EstudianteJpa;
import com.example.Sem2Estudiantes.infraestructure.repository.jpa.EstudianteRepository;
import com.example.Sem2Estudiantes.infraestructure.repository.port.FindByIdEstudiantePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class FindByIdEstudianteRepository implements FindByIdEstudiantePort {

    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public Optional<EstudianteJpa> findByIdEstudiante(Integer id) {
            Optional<EstudianteJpa> estudianteJpa = estudianteRepository.findById(id);
            return estudianteJpa;
    }
}
