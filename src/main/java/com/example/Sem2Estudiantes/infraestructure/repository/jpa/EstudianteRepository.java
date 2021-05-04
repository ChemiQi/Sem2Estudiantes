package com.example.Sem2Estudiantes.infraestructure.repository.jpa;

import com.example.Sem2Estudiantes.domain.EstudiantoJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<EstudiantoJpa,Integer> {
}
