package com.example.Sem2Estudiantes.student.exceptions;

public class FechasInvalidasException extends Exception{
    public FechasInvalidasException(String texto){
        super(texto);
    }
    public FechasInvalidasException(){
        super("Error con las fechas ingresadas");
    }
}
