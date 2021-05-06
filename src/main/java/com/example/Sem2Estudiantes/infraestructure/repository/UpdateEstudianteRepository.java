package com.example.Sem2Estudiantes.infraestructure.repository;

import com.example.Sem2Estudiantes.domain.EstudianteJpa;
import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoInput;
import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoOutput;
import com.example.Sem2Estudiantes.infraestructure.repository.jpa.EstudianteRepository;
import com.example.Sem2Estudiantes.infraestructure.repository.port.UpdateEstudiantePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UpdateEstudianteRepository implements UpdateEstudiantePort {
    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public ResponseEntity<EstudianteDtoOutput> actualizarEstudiante(int id,EstudianteDtoInput estudianteDtoInput) {
        return actualizarEstudianteRepository(id,estudianteDtoInput);
    }

    private ResponseEntity<EstudianteDtoOutput> actualizarEstudianteRepository(int id,EstudianteDtoInput estudianteDtoInput) {
        Optional<EstudianteJpa> estudianteOptional = estudianteRepository.findById(id); //USAR ELSETRHOW, pero nose muy bien como funciona
        if(estudianteOptional.isPresent()){
            EstudianteJpa estudianteEncontrado = estudianteOptional.get();
            estudianteRepository.save(actualizarDatosEstudiante(estudianteEncontrado,estudianteDtoInput));
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    private EstudianteJpa actualizarDatosEstudiante(EstudianteJpa estudianteEncontrado, EstudianteDtoInput estudianteDtoInput) {

        if(estudianteDtoInput.getNombre()!= null)
            estudianteEncontrado.setName(estudianteDtoInput.getNombre());
        if(estudianteDtoInput.getApellido() != null)
            estudianteEncontrado.setSurname(estudianteDtoInput.getApellido());
        if(estudianteDtoInput.getCorreo() != null)
            estudianteEncontrado.setPersonal_email(estudianteDtoInput.getCorreo());
        if(estudianteDtoInput.getEstado() != null)
            estudianteEncontrado.setEstado(estudianteDtoInput.getEstado());
        if(estudianteDtoInput.getCiudad() != null)
            estudianteEncontrado.setCity(estudianteDtoInput.getCiudad());
        if(estudianteDtoInput.getEspecialidad() != null)
            estudianteEncontrado.setEspecialidad(estudianteDtoInput.getEspecialidad());
        if(estudianteDtoInput.getFechaEntrada()!= null)
            estudianteEncontrado.setCreateDate(estudianteDtoInput.getFechaEntrada());
        if(estudianteDtoInput.getHorasSemanales() != 0.0){
            estudianteEncontrado.setNumHoursWeek(estudianteDtoInput.getHorasSemanales());
        }
        return estudianteEncontrado;
    }
}
