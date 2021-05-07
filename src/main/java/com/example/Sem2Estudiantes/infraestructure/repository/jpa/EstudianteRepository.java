package com.example.Sem2Estudiantes.infraestructure.repository.jpa;

import com.example.Sem2Estudiantes.domain.EstudianteJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.HashMap;
import java.util.List;

public interface EstudianteRepository extends CrudRepository<EstudianteJpa,String> {
    public List<EstudianteJpa> getData(HashMap<String,Object> conditions);
    public EstudianteJpa findByNameAndSurname(String name, String surname);
}
