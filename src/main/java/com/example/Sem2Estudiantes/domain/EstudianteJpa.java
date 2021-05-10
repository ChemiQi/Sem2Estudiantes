package com.example.Sem2Estudiantes.domain;

import com.example.Sem2Estudiantes.configurations.StringPrefixedSequenceIdGenerator;
import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoInput;
//import com.sun.istack.NotNull;  -> con está importancion no deja crear mensajes
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EstudianteJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estudiantes_seq")
    @GenericGenerator(
            name = "estudiantes_seq",
            strategy = "com.example.Sem2Estudiantes.configurations.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "EST"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            })
    String id_student;

    @NotNull(message = "Nombre necesario")
    String name;

    @NotNull
    String surname;

    @NotNull(message = "Correo electronico de empresa necesarias")
    @Email
    @NotBlank
    @Column(unique = true)
    String company_email;

    @NotNull(message = "Correo electronico personal necesario")
    @Email
    @NotBlank
    @Column(unique = true)
    String personal_email;

    @NotNull(message = "Ciudad necesaria")
    String city;

    @NotNull(message = "Horas Semanales necesario")
    Double numHoursWeek;

    String coments;

    @NotNull
    branch branch;

    @NotNull
    Boolean active;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")//@DateTimeFormat(pattern = "dd/MM/yyyy")
    Date createDate;
    @JsonFormat(pattern = "dd/MM/yyyy")//@DateTimeFormat(pattern = "dd/MM/yyyy")
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
