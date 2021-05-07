package com.example.Sem2Estudiantes.infraestructure.controller;

import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoInput;
import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoOutput;
import com.example.Sem2Estudiantes.infraestructure.repository.port.AddEstudiantePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("estudiante")
@CrossOrigin("*")
public class AddEstudianteController implements com.example.Sem2Estudiantes.infraestructure.repository.port.AddEstudiantePort {

    @Autowired
    private AddEstudiantePort addEstudiantePort;

    @PostMapping
    public ResponseEntity <EstudianteDtoOutput> añadirEstudiante(@Valid @RequestBody EstudianteDtoInput estudianteDtoInput){
        try{
            System.out.println(estudianteDtoInput.toString());
            return addEstudiantePort.añadirEstudiante(estudianteDtoInput);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

}
