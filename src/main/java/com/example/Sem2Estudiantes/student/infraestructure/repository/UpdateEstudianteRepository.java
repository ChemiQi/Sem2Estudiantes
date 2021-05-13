package com.example.Sem2Estudiantes.student.infraestructure.repository;

import com.example.Sem2Estudiantes.student.domain.EstudianteJpa;
import com.example.Sem2Estudiantes.student.exceptions.NombreYApellidoRepetidoException;
import com.example.Sem2Estudiantes.student.exceptions.NotFoundException;
import com.example.Sem2Estudiantes.student.infraestructure.controller.dto.EstudianteDtoInput;

import com.example.Sem2Estudiantes.student.infraestructure.repository.jpa.EstudianteRepository;
import com.example.Sem2Estudiantes.student.infraestructure.repository.port.UpdateEstudiantePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class UpdateEstudianteRepository implements UpdateEstudiantePort {
    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public void actualizarEstudiante(String id,EstudianteDtoInput estudianteDtoInput) throws Exception{
        EstudianteJpa estudianteEncontrado = estudianteRepository.findById(id).orElseThrow(() -> new NotFoundException()) ;

        if((estudianteDtoInput.getName() != null && estudianteEncontrado.getName() != estudianteDtoInput.getName()) || (estudianteDtoInput.getSurname() != null && estudianteEncontrado.getSurname() != estudianteDtoInput.getSurname())){//miro si el nombre y el apellido son distintos
            estudianteEncontrado = actualizarDatosEstudiante(estudianteEncontrado,estudianteDtoInput);
            if(!comprobarNombreYApellido(estudianteEncontrado)){
                estudianteRepository.save(estudianteEncontrado);
            }else {
                throw new NombreYApellidoRepetidoException();
            }
        }else{
            estudianteEncontrado = actualizarDatosEstudiante(estudianteEncontrado,estudianteDtoInput);
                estudianteRepository.save(estudianteEncontrado);
        }
    }


    private EstudianteJpa actualizarDatosEstudiante(EstudianteJpa estudianteEncontrado, EstudianteDtoInput estudianteDtoInput) {

        if(estudianteDtoInput.getName()!= null)
            estudianteEncontrado.setName(estudianteDtoInput.getName());
        if(estudianteDtoInput.getSurname() != null)
            estudianteEncontrado.setSurname(estudianteDtoInput.getSurname());
        if(estudianteDtoInput.getCompany_email() != null)
            estudianteEncontrado.setCompanyEmail(estudianteDtoInput.getCompany_email());
        if(estudianteDtoInput.getPersonal_email() != null)
            estudianteEncontrado.setPersonalEmail(estudianteDtoInput.getPersonal_email());
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
        return estudianteRepository.findByNameAndSurname(estudianteJpa.getName(),estudianteJpa.getSurname()) != null;
    }
}
