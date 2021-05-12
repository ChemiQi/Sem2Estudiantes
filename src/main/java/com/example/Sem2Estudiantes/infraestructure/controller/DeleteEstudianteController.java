package com.example.Sem2Estudiantes.infraestructure.controller;

import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoOutput;
import com.example.Sem2Estudiantes.infraestructure.repository.port.AddEstudiantePort;
import com.example.Sem2Estudiantes.infraestructure.repository.port.DeleteEstudiantePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("estudiante")
@CrossOrigin("*")
public class DeleteEstudianteController {

    @Autowired
    private DeleteEstudiantePort deleteEstudiantePort;

    @DeleteMapping("{id}")
    public ResponseEntity borrarEstudiante(@PathVariable String id) throws Exception {
        try {
            deleteEstudiantePort.borrarEstudiante(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Borrado correctamente");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
