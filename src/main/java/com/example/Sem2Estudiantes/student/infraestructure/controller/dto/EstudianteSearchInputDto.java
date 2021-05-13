package com.example.Sem2Estudiantes.student.infraestructure.controller.dto;

import com.example.Sem2Estudiantes.student.domain.branch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteSearchInputDto {

    String name;
    String surname;
    String company_email;
    String personal_email;
    String city;
    Integer numHoursWeek;
    String coments;
    branch branch;
    Boolean active;
    Date createDate;
    Date terminationDate;
}
