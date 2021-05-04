package com.example.Sem2Estudiantes.infraestructure.repository.jpa;

import com.example.Sem2Estudiantes.domain.EstudianteJpa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;
import java.util.List;

public interface EstudianteRepository extends JpaRepository<EstudianteJpa,Integer> {
    public List<EstudianteJpa> getData(HashMap<String,Object> conditions);
}
