package com.example.Sem2Estudiantes.infraestructure.repository;

import com.example.Sem2Estudiantes.domain.EstudiantoJpa;
import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoInput;
import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoOutput;
import com.example.Sem2Estudiantes.infraestructure.repository.jpa.EstudianteRepository;
import com.example.Sem2Estudiantes.infraestructure.repository.port.AddEstudiantePort;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;


@Repository
public class AddEstudianteRepository implements AddEstudiantePort {
    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public ResponseEntity<EstudianteDtoOutput> añadirEstudiante(EstudianteDtoInput estudianteDtoInput) {
        try{
            return añadirEstudianteRepository(estudianteDtoInput);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    private ResponseEntity<EstudianteDtoOutput> añadirEstudianteRepository(EstudianteDtoInput estudianteDtoInput){
        try {
            estudianteRepository.save(new EstudiantoJpa(estudianteDtoInput));
           EstudianteDtoOutput estudianteDtoOutput =  new EstudianteDtoOutput(estudianteDtoInput);
           return ResponseEntity.ok(estudianteDtoOutput);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
