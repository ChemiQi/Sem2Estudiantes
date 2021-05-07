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

    String surname;
    String company_email;
    String personal_email;
    String city;
    double numHoursWeek;
    String coments;
    branch branch;
    boolean active;
    Date createDate;
    Date terminationDate;
}
