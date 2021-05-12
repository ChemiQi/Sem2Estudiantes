package com.example.Sem2Estudiantes.infraestructure.controller;

import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoInput;
import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoOutput;
import com.example.Sem2Estudiantes.infraestructure.repository.port.AddEstudiantePort;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;


@RestController
@RequestMapping("estudiante")
@CrossOrigin("*")
@Slf4j
//TODO un controller NUNCA implementa nada.
@AllArgsConstructor
public class AddEstudianteController  {
    private AddEstudiantePort addEstudiantePort;

    @PostMapping
    public ResponseEntity añadirEstudiante(@Valid @RequestBody EstudianteDtoInput estudianteDtoInput)  {
        try{
            // Error - Warning - Info - trace - Debug
            log.debug("");
            System.out.println(estudianteDtoInput.toString());
            addEstudiantePort.añadirEstudiante(estudianteDtoInput);
            return  ResponseEntity.status(HttpStatus.CREATED).body("Creado correctamente");
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
