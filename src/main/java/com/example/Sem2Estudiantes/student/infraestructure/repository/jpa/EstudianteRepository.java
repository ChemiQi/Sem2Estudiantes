package com.example.Sem2Estudiantes.student.infraestructure.repository.jpa;

import com.example.Sem2Estudiantes.student.domain.EstudianteJpa;
import org.springframework.data.repository.CrudRepository;

import java.util.HashMap;
import java.util.List;

public interface EstudianteRepository extends CrudRepository<EstudianteJpa,String> {
    public List<EstudianteJpa> getData(HashMap<String,Object> conditions);
    public EstudianteJpa findByNameAndSurname(String name, String surname);
    public EstudianteJpa findByPersonalEmail(String personal_email);
    public EstudianteJpa findByCompanyEmail(String company_email);
}
