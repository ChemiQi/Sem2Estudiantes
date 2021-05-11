package com.example.Sem2Estudiantes.infraestructure.repository;

import com.example.Sem2Estudiantes.domain.EstudianteJpa;
import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoInput;
import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoOutput;
import com.example.Sem2Estudiantes.infraestructure.repository.jpa.EstudianteRepository;
import com.example.Sem2Estudiantes.infraestructure.repository.port.AddEstudiantePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;


@Repository
public class AddEstudianteRepository implements AddEstudiantePort {
    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public ResponseEntity<EstudianteDtoOutput> añadirEstudiante(EstudianteDtoInput estudianteDtoInput) throws Exception{
        if(comprobarFechaEntradaySalida(estudianteDtoInput)) {
            try {
                return añadirEstudianteRepository(estudianteDtoInput);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
            }
        }else {
            //TODO porque no lanza directamente la exception la funcion comprobarFechaEntrada ?
            throw new Exception("Fecha de entrada mayor que fecha salida");
        }
    }

    //TODO los Repository no deben devolver ResponseEntity. Eso es labor del controlador.
    private ResponseEntity<EstudianteDtoOutput> añadirEstudianteRepository(EstudianteDtoInput estudianteDtoInput)
    {

        if(!comprobarNombreYApellido(estudianteDtoInput)) {
            try {
                estudianteRepository.save(new EstudianteJpa(estudianteDtoInput));
                EstudianteDtoOutput estudianteDtoOutput = new EstudianteDtoOutput(estudianteDtoInput);
                return ResponseEntity.ok(estudianteDtoOutput);
            } catch (Exception e) {
                return ResponseEntity.notFound().build(); // hemos puesto notFound porque no sabemos muy bien cual poner
            }
        }else{
            //TODO que mensaje es este :-D
            System.out.println("NO ENTRA EN EL ENCONTRAR APELLIDO Y BOMBRE");

            return ResponseEntity.notFound().build();
        }

    }
    private boolean comprobarNombreYApellido(EstudianteDtoInput estudianteDtoInput){
        //TODO cambiar por
         return estudianteRepository.findByNameAndSurname(estudianteDtoInput.getName(),estudianteDtoInput.getSurname()) != null;
//        if(estudianteRepository.findByNameAndSurname(estudianteDtoInput.getName(),estudianteDtoInput.getSurname()) != null){
//            return true;
//        }
//        return false;
    }
    private boolean comprobarFechaEntradaySalida(EstudianteDtoInput estudianteDtoInput){
        //TODO Y si la fecha de inicio es null que pasa ?. Cambiar por return directamente
        if(estudianteDtoInput.getTerminationDate() != null && !estudianteDtoInput.getCreateDate().before(estudianteDtoInput.getTerminationDate())){
            return false;
        }else{
            return true;
        }
    }
}
