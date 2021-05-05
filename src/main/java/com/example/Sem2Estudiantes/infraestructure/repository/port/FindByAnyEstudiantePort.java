package com.example.Sem2Estudiantes.infraestructure.repository.port;

import com.example.Sem2Estudiantes.domain.EstudianteJpa;
import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoOutput;

import java.util.HashMap;
import java.util.List;

public interface FindByAnyEstudiantePort {
    //List<EstudianteDtoOutput> listaPersonalizada(String nombre_tabla, String parametro);

    List<EstudianteJpa> listaPersonalizada2(HashMap<String, Object> conditions);
}
