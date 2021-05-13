package com.example.Sem2Estudiantes.student.infraestructure.controller.dto;

import com.example.Sem2Estudiantes.student.domain.EstudianteJpa;
import com.example.Sem2Estudiantes.student.domain.branch;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteDtoOutput {


    @NotNull
    String name;

    @NotNull
    String surname;

    @NotNull
    String company_email;

    @NotNull
    String personal_email;

    @NotNull
    String city;

    @NotNull
    Double numHoursWeek;

    @NotNull
    String coments;

    @NotNull
    branch branch;

    @NotNull
    Boolean active;


    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date createDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date terminationDate;

    public EstudianteDtoOutput(EstudianteDtoInput estudianteDtoInput){
        this.name = estudianteDtoInput.getName();
        this.surname = estudianteDtoInput.getSurname();
        this.personal_email = estudianteDtoInput.getPersonal_email();
        this.company_email = estudianteDtoInput.getCompany_email();
        this.createDate = estudianteDtoInput.getCreateDate();
        this.city = estudianteDtoInput.getCity();
        this.numHoursWeek = estudianteDtoInput.getNumHoursWeek();
        this.coments = estudianteDtoInput.getComents();
        this.branch = estudianteDtoInput.getBranch();
        this.active = estudianteDtoInput.getActive();
        this.terminationDate = estudianteDtoInput.getTerminationDate();
    }

    public EstudianteDtoOutput(EstudianteJpa estudianteJpa){

        this.name = estudianteJpa.getName();
        this.surname = estudianteJpa.getSurname();
        this.personal_email = estudianteJpa.getPersonalEmail();
        this.company_email = estudianteJpa.getCompanyEmail();
        this.createDate = estudianteJpa.getCreateDate();
        this.city = estudianteJpa.getCity();
        this.numHoursWeek = estudianteJpa.getNumHoursWeek();
        this.coments = estudianteJpa.getComents();
        this.branch = estudianteJpa.getBranch();
        this.active = estudianteJpa.getActive();
        this.terminationDate = estudianteJpa.getTerminationDate();
        //this.especialidad = estudianteJpa.getEspecialidad();
        //this.estado = estudianteJpa.getEstado();
    }
}
