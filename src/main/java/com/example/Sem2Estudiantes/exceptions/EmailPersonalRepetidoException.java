package com.example.Sem2Estudiantes.exceptions;

public class EmailPersonalRepetidoException extends Exception{
    public EmailPersonalRepetidoException(){
        super();
    }

    public EmailPersonalRepetidoException(String texto){
        super(texto);
    }
}
