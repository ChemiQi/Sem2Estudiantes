package com.example.Sem2Estudiantes.infraestructure.controller.dto;

import com.example.Sem2Estudiantes.domain.branch;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteSearchInputDto {
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
}
