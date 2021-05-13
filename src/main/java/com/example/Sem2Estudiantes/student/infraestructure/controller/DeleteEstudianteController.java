package com.example.Sem2Estudiantes.student.infraestructure.controller;

import com.example.Sem2Estudiantes.student.infraestructure.repository.port.DeleteEstudiantePort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("estudiante")
@CrossOrigin("*")
public class DeleteEstudianteController {

    @Autowired
    private DeleteEstudiantePort deleteEstudiantePort;

    @DeleteMapping("{id}")
    public ResponseEntity borrarEstudiante(@PathVariable String id) throws Exception {
        try {
            log.info("Borrando estudiante");
            deleteEstudiantePort.borrarEstudiante(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Borrado correctamente");
        }catch (Exception e){
            log.error("Error al borrar estudiante", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
