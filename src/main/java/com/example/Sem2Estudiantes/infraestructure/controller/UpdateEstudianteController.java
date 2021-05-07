package com.example.Sem2Estudiantes.infraestructure.controller;


import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoInput;
import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoOutput;
import com.example.Sem2Estudiantes.infraestructure.repository.port.UpdateEstudiantePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("estudiante")
@CrossOrigin("*")
public class UpdateEstudianteController {

    @Autowired
    UpdateEstudiantePort updateEstudiantePort;

    @PutMapping("{id}")
    public ResponseEntity<EstudianteDtoOutput> actualizarEstudiante(@PathVariable String id,@RequestBody EstudianteDtoInput estudianteDtoInput){
        try{
            System.out.println("ENTRA");
            return updateEstudiantePort.actualizarEstudiante( id,estudianteDtoInput);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
