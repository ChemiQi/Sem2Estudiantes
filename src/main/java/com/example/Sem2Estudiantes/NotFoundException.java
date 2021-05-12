package com.example.Sem2Estudiantes;

public class NotFoundException extends Exception{
    public NotFoundException(){}

    public NotFoundException(String msj_error){
        super(msj_error);
    }
}
