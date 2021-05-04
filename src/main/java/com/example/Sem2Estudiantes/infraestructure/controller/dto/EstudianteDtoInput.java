package com.example.Sem2Estudiantes.infraestructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;


@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteDtoInput {

    String nombre;
    String apellido;
    String correo;
    Date fechaEntrada;
    String ciudad;
    double horasSemanales;
    String especialidad;
    String estado;
}
