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
    public ResponseEntity<EstudianteDtoOutput> actualizarEstudiante(String id,EstudianteDtoInput estudianteDtoInput) {
        return actualizarEstudianteRepository(id,estudianteDtoInput);
    }

    private ResponseEntity<EstudianteDtoOutput> actualizarEstudianteRepository(String id,EstudianteDtoInput estudianteDtoInput) {
        Optional<EstudianteJpa> estudianteOptional = estudianteRepository.findById(id); //USAR ELSETRHOW, pero nose muy bien como funciona
        if(estudianteOptional.isPresent()){
            EstudianteJpa estudianteEncontrado = estudianteOptional.get();
            EstudianteJpa estudianteActualizado = actualizarDatosEstudiante(estudianteEncontrado,estudianteDtoInput);
            if(!comprobarNombreYApellido(estudianteActualizado)){
               // estudianteRepository.save(actualizarDatosEstudiante(estudianteEncontrado,estudianteDtoInput));
                estudianteRepository.save(estudianteActualizado);  //--> No se si es la mejor manera de hacerlo, ya que ocupo espacio al guardar estudianteActualizado
                return ResponseEntity.ok().build();
            }else {
                System.out.println("No actualiza, nombre y apellidos repetidos");
                return ResponseEntity.notFound().build();
            }
        }else{
            System.out.println("No encuentra el id del estudiante a actualizar");
            return ResponseEntity.notFound().build();
        }
    }

    private EstudianteJpa actualizarDatosEstudiante(EstudianteJpa estudianteEncontrado, EstudianteDtoInput estudianteDtoInput) {

        if(estudianteDtoInput.getName()!= null)
            estudianteEncontrado.setName(estudianteDtoInput.getName());
        if(estudianteDtoInput.getSurname() != null)
            estudianteEncontrado.setSurname(estudianteDtoInput.getSurname());
        if(estudianteDtoInput.getCompany_email() != null)
            estudianteEncontrado.setPersonal_email(estudianteDtoInput.getCompany_email());
        if(estudianteDtoInput.getPersonal_email() != null)
            estudianteEncontrado.setPersonal_email(estudianteDtoInput.getPersonal_email());
        if(estudianteDtoInput.getComents() != null)
            estudianteEncontrado.setComents(estudianteDtoInput.getComents());
        if(estudianteDtoInput.getCity() != null)
            estudianteEncontrado.setCity(estudianteDtoInput.getCity());
        if(estudianteDtoInput.getBranch() != null)
            estudianteEncontrado.setBranch(estudianteDtoInput.getBranch());
        if(estudianteDtoInput.getCreateDate()!= null)
            estudianteEncontrado.setCreateDate(estudianteDtoInput.getCreateDate());
        if(estudianteDtoInput.getTerminationDate()!= null)
            estudianteEncontrado.setTerminationDate(estudianteDtoInput.getTerminationDate());
        if(estudianteDtoInput.getNumHoursWeek() != 0.0){
            estudianteEncontrado.setNumHoursWeek(estudianteDtoInput.getNumHoursWeek());

        }
        return estudianteEncontrado;
    }

    private boolean comprobarNombreYApellido(EstudianteJpa estudianteJpa){
        if(estudianteRepository.findByNameAndSurname(estudianteJpa.getName(),estudianteJpa.getSurname()) != null){
            return true;
        }
        return false;
    }
}
