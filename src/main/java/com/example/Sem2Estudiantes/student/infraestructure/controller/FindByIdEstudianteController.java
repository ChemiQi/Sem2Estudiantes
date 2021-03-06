package com.example.Sem2Estudiantes.student.infraestructure.controller;

import com.example.Sem2Estudiantes.student.infraestructure.repository.port.FindByIdEstudiantePort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("estudiante")
@CrossOrigin("*")
public class FindByIdEstudianteController {

    @Autowired
    private FindByIdEstudiantePort findByIdEstudiantePort;

    @GetMapping("{id}")
    public ResponseEntity<?> findByIdEstudiante(@PathVariable String id){
        try {
            log.info("Buscando estudiante por id");
            return ResponseEntity.ok(findByIdEstudiantePort.findByIdEstudiante(id));

        }catch (Exception e){
            log.error("Estudiante no encontrado con id:"+id, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}
