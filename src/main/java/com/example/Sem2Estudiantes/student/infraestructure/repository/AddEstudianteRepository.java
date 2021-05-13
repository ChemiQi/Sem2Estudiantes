package com.example.Sem2Estudiantes.student.infraestructure.repository;

import com.example.Sem2Estudiantes.student.domain.EstudianteJpa;
import com.example.Sem2Estudiantes.student.exceptions.EmailPersonalRepetidoException;
import com.example.Sem2Estudiantes.student.exceptions.FechasInvalidasException;
import com.example.Sem2Estudiantes.student.exceptions.NombreYApellidoRepetidoException;
import com.example.Sem2Estudiantes.student.infraestructure.controller.dto.EstudianteDtoInput;
import com.example.Sem2Estudiantes.student.infraestructure.controller.dto.EstudianteDtoOutput;
import com.example.Sem2Estudiantes.student.infraestructure.repository.jpa.EstudianteRepository;
import com.example.Sem2Estudiantes.student.infraestructure.repository.port.AddEstudiantePort;
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
            throw new FechasInvalidasException("Fecha de entrada mayor que fecha salida");
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
            throw new Exception(); // ME OBLIGA A PONER ESTO
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
            throw new NombreYApellidoRepetidoException();
        if(estudianteRepository.findByPersonalEmail(estudianteDtoInput.getPersonal_email()) != null)
            throw new EmailPersonalRepetidoException("Email personal ya existente");
        if(estudianteRepository.findByCompanyEmail(estudianteDtoInput.getCompany_email()) != null)
            throw new EmailPersonalRepetidoException("Email de empresa repetida");

        return true;
    }
}
