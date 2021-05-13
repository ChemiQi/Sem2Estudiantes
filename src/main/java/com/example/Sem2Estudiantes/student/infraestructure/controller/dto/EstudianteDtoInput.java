package com.example.Sem2Estudiantes.student.infraestructure.controller.dto;

import com.example.Sem2Estudiantes.student.domain.branch;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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

    Double numHoursWeek;

    String coments;

    branch branch;

    Boolean active;

    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    Date createDate;
    //@DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    Date terminationDate;
}
