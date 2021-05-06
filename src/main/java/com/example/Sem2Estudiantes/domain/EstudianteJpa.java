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
    int id_student;

    String name;
    String surname;
    String company_email;
    String personal_email;
    String city;
    double numHoursWeek;
    String coments;
    //branch
    String especialidad;
    boolean active;
    Date createDate;
    Date terminationDate;


    public EstudianteJpa(EstudianteDtoInput estudianteDtoInput){
        this.name = estudianteDtoInput.getNombre();
        this.surname = estudianteDtoInput.getApellido();
        this.personal_email = estudianteDtoInput.getCorreo();
        this.createDate = estudianteDtoInput.getFechaEntrada();
        this.city = estudianteDtoInput.getCiudad();
        this.numHoursWeek = estudianteDtoInput.getHorasSemanales();
        this.especialidad = estudianteDtoInput.getEspecialidad();
        //this.estado = estudianteDtoInput.getEstado();
    }
}
