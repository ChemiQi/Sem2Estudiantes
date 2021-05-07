package com.example.Sem2Estudiantes.domain;

import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoInput;
//import com.sun.istack.NotNull;  -> con está importancion no deja crear mensajes
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.IncrementGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EstudianteJpa {
    //Id, Nombre,Apellido, correo, Fecha Entrada, Ciudad, Numero Horas semanales, Especialidad (Front/Back/..),Estado (activo/inactivo);

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estudiantes_seq")
    @GenericGenerator(name = "estudiantes_seq", strategy = "uuid")
    String id_student;

    @NotNull(message = "Nombre necesario")
    String name;

    @NotNull
    String surname;

    @NotNull(message = "Correo electronico de empresa necesarias")
    @Email(regexp=".*@.*\\..*", message = "Email formato incorrecto")
    @Column(unique = true)
    String company_email;

    @NotNull(message = "Correo electronico personal necesario")
    @Email(regexp=".*@.*\\..*", message = "Email formato incorrecto")
    @Column(unique = true)
    String personal_email;

    @NotNull(message = "Ciudad necesaria")
    String city;

    @NotNull(message = "Horas Semanales necesario")
    double numHoursWeek;

    String coments;

    @NotNull
    branch branch;

    @NotNull
    boolean active;

    @NotNull
    Date createDate;
    Date terminationDate;



    public EstudianteJpa(EstudianteDtoInput estudianteDtoInput){
        this.name = estudianteDtoInput.getName();
        this.surname = estudianteDtoInput.getSurname();
        this.personal_email = estudianteDtoInput.getPersonal_email();
        this.company_email = estudianteDtoInput.getCompany_email();
        this.createDate = estudianteDtoInput.getCreateDate();
        this.city = estudianteDtoInput.getCity();
        this.numHoursWeek = estudianteDtoInput.getNumHoursWeek();
        this.coments = estudianteDtoInput.getComents();
        this.branch = estudianteDtoInput.getBranch();
        this.active = estudianteDtoInput.isActive();
        this.terminationDate = estudianteDtoInput.getTerminationDate();
        //this.especialidad = estudianteDtoInput.getEspecialidad();
        //this.estado = estudianteDtoInput.getEstado();
    }
}
