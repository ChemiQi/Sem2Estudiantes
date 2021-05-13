package com.example.Sem2Estudiantes.student.exceptions;

public class EmailPersonalRepetidoException extends Exception{
    public EmailPersonalRepetidoException(){
        super();
    }

    public EmailPersonalRepetidoException(String texto){
        super(texto);
    }
}
