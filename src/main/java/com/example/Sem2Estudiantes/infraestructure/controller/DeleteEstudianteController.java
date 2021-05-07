package com.example.Sem2Estudiantes.infraestructure.controller;

import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoOutput;
import com.example.Sem2Estudiantes.infraestructure.repository.port.AddEstudiantePort;
import com.example.Sem2Estudiantes.infraestructure.repository.port.DeleteEstudiantePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("estudiante")
@CrossOrigin("*")
public class DeleteEstudianteController {

    @Autowired
    private DeleteEstudiantePort deleteEstudiantePort;

    @DeleteMapping("{id}")
    public ResponseEntity<EstudianteDtoOutput> borrarEstudiante(@PathVariable String id){
        try{
            return deleteEstudiantePort.borrarEstudiante(id);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
