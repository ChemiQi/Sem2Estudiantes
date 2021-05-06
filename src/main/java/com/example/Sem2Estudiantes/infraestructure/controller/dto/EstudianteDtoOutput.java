package com.example.Sem2Estudiantes.infraestructure.controller.dto;

import com.example.Sem2Estudiantes.domain.EstudianteJpa;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import java.util.Date;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteDtoOutput {

    String nombre;
    String apellido;
    String correo;
    Date fechaEntrada;
    String ciudad;
    double horasSemanales;
    String especialidad;
    String estado;

    public EstudianteDtoOutput(EstudianteDtoInput estudianteDtoInput){
        this.nombre = estudianteDtoInput.getNombre();
        this.apellido = estudianteDtoInput.getApellido();
        this.correo = estudianteDtoInput.getCorreo();
        this.fechaEntrada = estudianteDtoInput.getFechaEntrada();
        this.ciudad = estudianteDtoInput.getCiudad();
        this.horasSemanales = estudianteDtoInput.getHorasSemanales();
        this.especialidad = estudianteDtoInput.getEspecialidad();
        this.estado = estudianteDtoInput.getEstado();
    }

    public EstudianteDtoOutput(EstudianteJpa estudianteJpa){
        this.nombre = estudianteJpa.getName();
        this.apellido = estudianteJpa.getSurname();
        this.correo = estudianteJpa.getPersonal_email();
        this.fechaEntrada = estudianteJpa.getCreateDate();
        this.ciudad = estudianteJpa.getCity();
        this.horasSemanales = estudianteJpa.getNumHoursWeek();
        this.especialidad = estudianteJpa.getEspecialidad();
        this.estado = estudianteJpa.getEstado();
    }
}
