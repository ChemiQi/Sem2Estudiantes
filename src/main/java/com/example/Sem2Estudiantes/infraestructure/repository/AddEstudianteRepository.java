package com.example.Sem2Estudiantes.infraestructure.repository;

import com.example.Sem2Estudiantes.domain.EstudianteJpa;
import com.example.Sem2Estudiantes.exceptions.EmailPersonalRepetidoException;
import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoInput;
import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoOutput;
import com.example.Sem2Estudiantes.infraestructure.repository.jpa.EstudianteRepository;
import com.example.Sem2Estudiantes.infraestructure.repository.port.AddEstudiantePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class AddEstudianteRepository implements AddEstudiantePort {
    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public EstudianteDtoOutput añadirEstudiante(EstudianteDtoInput estudianteDtoInput) throws Exception{
        if(comprobarFechaEntradaySalida(estudianteDtoInput)) {
                return añadirEstudianteRepository(estudianteDtoInput);
        }else {
            //TODO porque no lanza directamente la exception la funcion comprobarFechaEntrada ?
            throw new Exception("Fecha de entrada mayor que fecha salida");
        }
    }

    //TODO los Repository no deben devolver ResponseEntity. Eso es labor del controlador. -> corregido
    private EstudianteDtoOutput añadirEstudianteRepository(EstudianteDtoInput estudianteDtoInput) throws Exception
    {
        if(comprobarDatos(estudianteDtoInput)) {
                estudianteRepository.save(new EstudianteJpa(estudianteDtoInput));
                EstudianteDtoOutput estudianteDtoOutput = new EstudianteDtoOutput(estudianteDtoInput);
                return estudianteDtoOutput;
        }else{
            throw new Exception("");
        }

    }
    private boolean comprobarFechaEntradaySalida(EstudianteDtoInput estudianteDtoInput) throws Exception{
        //TODO Y si la fecha de inicio es null que pasa ?. Cambiar por return directamente
        if(estudianteDtoInput.getTerminationDate() == null){
            return true;
        }else{
            return estudianteDtoInput.getCreateDate().before(estudianteDtoInput.getTerminationDate());
        }
    }

    private boolean comprobarDatos(EstudianteDtoInput estudianteDtoInput) throws Exception{
        if(estudianteRepository.findByNameAndSurname(estudianteDtoInput.getName(),estudianteDtoInput.getSurname()) != null)
            throw new Exception("Nombre y apellidos duplicados");
        if(estudianteRepository.findByPersonalEmail(estudianteDtoInput.getPersonal_email()) != null)
            throw new EmailPersonalRepetidoException();
        if(estudianteRepository.findByCompanyEmail(estudianteDtoInput.getCompany_email()) != null)
            throw new Exception("Email de empresa repetida");

        return true;
    }
}
