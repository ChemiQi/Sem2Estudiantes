package com.example.Sem2Estudiantes.exceptions;

public class EmailPersonalRepetidoException extends Exception{
    public EmailPersonalRepetidoException(){
        super("Email personal ya existente");
    }
}
