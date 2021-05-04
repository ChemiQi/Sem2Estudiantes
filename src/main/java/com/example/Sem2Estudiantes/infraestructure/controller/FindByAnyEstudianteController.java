package com.example.Sem2Estudiantes.infraestructure.controller;

import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoOutput;
import com.example.Sem2Estudiantes.infraestructure.repository.port.FindByAnyEstudiantePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("estudiante")
@CrossOrigin("*")
public class FindByAnyEstudianteController {

    @Autowired
    FindByAnyEstudiantePort findByAnyEstudiantePort;

    @GetMapping
    public List<EstudianteDtoOutput> buscarPorParametros(@RequestBody String nombreTabla, String parametro){
       System.out.println(nombreTabla + " " + parametro);
        return findByAnyEstudiantePort.listaPersonalizada("nombre","Chema");
    }
}
