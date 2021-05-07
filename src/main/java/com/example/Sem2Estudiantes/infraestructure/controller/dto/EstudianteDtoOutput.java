package com.example.Sem2Estudiantes.infraestructure.controller.dto;

import com.example.Sem2Estudiantes.domain.EstudianteJpa;
import com.example.Sem2Estudiantes.domain.branch;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


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
    double numHoursWeek;

    String coments;

    @NotNull
    branch branch;

    @NotNull
    boolean active;

    @NotNull
    Date createDate;
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
        this.active = estudianteDtoInput.isActive();
        this.terminationDate = estudianteDtoInput.getTerminationDate();
    }

    public EstudianteDtoOutput(EstudianteJpa estudianteJpa){

        this.name = estudianteJpa.getName();
        this.surname = estudianteJpa.getSurname();
        this.personal_email = estudianteJpa.getPersonal_email();
        this.company_email = estudianteJpa.getCompany_email();
        this.createDate = estudianteJpa.getCreateDate();
        this.city = estudianteJpa.getCity();
        this.numHoursWeek = estudianteJpa.getNumHoursWeek();
        this.coments = estudianteJpa.getComents();
        this.branch = estudianteJpa.getBranch();
        this.active = estudianteJpa.isActive();
        this.terminationDate = estudianteJpa.getTerminationDate();
        //this.especialidad = estudianteJpa.getEspecialidad();
        //this.estado = estudianteJpa.getEstado();
    }
}
