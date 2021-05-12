package com.example.Sem2Estudiantes.exceptions;

public class NombreYApellidoRepetidoException extends Exception{
    public NombreYApellidoRepetidoException(){
        super("Nombre y apellidos ya existentes");
    }
}
