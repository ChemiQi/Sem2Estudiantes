package com.example.Sem2Estudiantes.domain;

import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoInput;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EstudianteJpa {
    //Id, Nombre,Apellido, correo, Fecha Entrada, Ciudad, Numero Horas semanales, Especialidad (Front/Back/..),Estado (activo/inactivo);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String nombre;
    String apellido;
    String correo;
    Date fechaEntrada;
    String ciudad;
    double horasSemanales;
    String especialidad;
    String estado;

    public EstudianteJpa(EstudianteDtoInput estudianteDtoInput){
        this.nombre = estudianteDtoInput.getNombre();
        this.apellido = estudianteDtoInput.getApellido();
        this.correo = estudianteDtoInput.getCorreo();
        this.fechaEntrada = estudianteDtoInput.getFechaEntrada();
        this.ciudad = estudianteDtoInput.getCiudad();
        this.horasSemanales = estudianteDtoInput.getHorasSemanales();
        this.especialidad = estudianteDtoInput.getEspecialidad();
        this.estado = estudianteDtoInput.getEstado();
    }
}
