package com.example.Sem2Estudiantes.student.infraestructure.repository.port;

import com.example.Sem2Estudiantes.student.domain.EstudianteJpa;
import com.example.Sem2Estudiantes.student.infraestructure.controller.dto.EstudianteDtoOutput;

import java.util.HashMap;
import java.util.List;

public interface FindByAnyEstudiantePort {
    List<EstudianteDtoOutput> listaPersonalizada(String nombre_tabla, String parametro);

    List<EstudianteJpa> listaPersonalizada2(HashMap<String, Object> estudianteSearchInputDto);

    //List<EstudianteJpa> listaPersonalizada2(EstudianteSearchInputDto estudianteSearchInputDto);
}
