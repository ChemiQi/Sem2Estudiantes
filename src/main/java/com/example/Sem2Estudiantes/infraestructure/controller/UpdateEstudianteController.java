package com.example.Sem2Estudiantes.infraestructure.controller;


import com.example.Sem2Estudiantes.exceptions.NombreYApellidoRepetidoException;
import com.example.Sem2Estudiantes.exceptions.NotFoundException;
import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoInput;
import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoOutput;
import com.example.Sem2Estudiantes.infraestructure.repository.port.UpdateEstudiantePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("estudiante")
@CrossOrigin("*")
public class UpdateEstudianteController {

    @Autowired
    UpdateEstudiantePort updateEstudiantePort;

    @PutMapping("{id}")
    public ResponseEntity actualizarEstudiante(@PathVariable String id,@RequestBody EstudianteDtoInput estudianteDtoInput){
        try{
            updateEstudiantePort.actualizarEstudiante( id,estudianteDtoInput);
            return ResponseEntity.ok("Actualizado correctamente");
        }catch(NotFoundException notFoundException){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundException.getMessage());
        }catch (NombreYApellidoRepetidoException nombreYApellidoRepetidoException){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(nombreYApellidoRepetidoException.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
