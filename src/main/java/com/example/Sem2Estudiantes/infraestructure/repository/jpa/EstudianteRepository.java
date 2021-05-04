package com.example.Sem2Estudiantes.infraestructure.repository.jpa;

import com.example.Sem2Estudiantes.domain.EstudianteJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<EstudianteJpa,Integer> {
}
