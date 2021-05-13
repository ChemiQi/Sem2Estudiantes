package com.example.Sem2Estudiantes.student.exceptions;

public class NotFoundException extends Exception{
    public NotFoundException(){
        super("Estudiante con ID no encontrado");
    }

    public NotFoundException(String msj_error){
        super(msj_error);
    }
}
