package com.example.Sem2Estudiantes.infraestructure.controller.dto;

import com.example.Sem2Estudiantes.domain.branch;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteDtoInput {

    //TODO comprobar que los campos no sean nulos
    String name;

    String surname;

    String company_email;

    String personal_email;

    String city;

    double numHoursWeek;

    String coments;

    branch branch;

    boolean active;

    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    Date createDate;
    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    Date terminationDate;
}
