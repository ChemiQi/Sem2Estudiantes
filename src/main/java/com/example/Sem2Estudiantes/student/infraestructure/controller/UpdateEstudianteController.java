package com.example.Sem2Estudiantes.student.infraestructure.controller;


import com.example.Sem2Estudiantes.student.exceptions.NombreYApellidoRepetidoException;
import com.example.Sem2Estudiantes.student.exceptions.NotFoundException;
import com.example.Sem2Estudiantes.student.infraestructure.controller.dto.EstudianteDtoInput;
import com.example.Sem2Estudiantes.student.infraestructure.repository.port.UpdateEstudiantePort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping("estudiante")
@CrossOrigin("*")
public class UpdateEstudianteController {

    @Autowired
    UpdateEstudiantePort updateEstudiantePort;

    @PutMapping("{id}")
    public ResponseEntity actualizarEstudiante(@PathVariable String id,@RequestBody EstudianteDtoInput estudianteDtoInput){
        try{
            log.info("Aztualizando estudiante");
            updateEstudiantePort.actualizarEstudiante( id,estudianteDtoInput);
            return ResponseEntity.ok("Actualizado correctamente");
        }catch(NotFoundException notFoundException){
            log.error("Estudiante no encontrado", notFoundException);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundException.getMessage());
        }catch (NombreYApellidoRepetidoException nombreYApellidoRepetidoException){
            log.error("Nombre y Apellido repetido", nombreYApellidoRepetidoException);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(nombreYApellidoRepetidoException.getMessage());
        }catch (Exception e){
            log.error("Error al actulizar estudiante", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
