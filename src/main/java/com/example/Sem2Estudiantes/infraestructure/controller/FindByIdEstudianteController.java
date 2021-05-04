package com.example.Sem2Estudiantes.infraestructure.controller;

import com.example.Sem2Estudiantes.domain.EstudianteJpa;
import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoOutput;

import com.example.Sem2Estudiantes.infraestructure.repository.port.FindByIdEstudiantePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("estudiante")
@CrossOrigin("*")
public class FindByIdEstudianteController {

    @Autowired
    private FindByIdEstudiantePort findByIdEstudiantePort;

    @GetMapping("{id}")
    public EstudianteDtoOutput findByIdEstudiante(@PathVariable Integer id){
        return findByIdEstudiantePort.findByIdEstudiante(id);
    }
}
