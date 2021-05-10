package com.example.Sem2Estudiantes.infraestructure.repository;

import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoOutput;
import com.example.Sem2Estudiantes.infraestructure.repository.jpa.EstudianteRepository;
import com.example.Sem2Estudiantes.infraestructure.repository.port.DeleteEstudiantePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class DeleteEstudianteRepository implements DeleteEstudiantePort {

    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public ResponseEntity<EstudianteDtoOutput> borrarEstudiante(String id) throws Exception{
        try{
            estudianteRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            throw new Exception("Error al borrar por ID");
        }
    }
}
