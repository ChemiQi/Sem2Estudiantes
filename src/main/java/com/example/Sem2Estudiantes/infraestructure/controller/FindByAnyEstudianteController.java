package com.example.Sem2Estudiantes.infraestructure.controller;

import com.example.Sem2Estudiantes.domain.EstudianteJpa;
import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoOutput;
import com.example.Sem2Estudiantes.infraestructure.repository.port.FindByAnyEstudiantePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("estudiante")
@CrossOrigin("*")
public class FindByAnyEstudianteController {

    @Autowired
    FindByAnyEstudiantePort findByAnyEstudiantePort;

    @GetMapping
    public List<EstudianteJpa> buscarPorParametros(@RequestParam(required = false) String nombre,
                                                   @RequestParam(required = false) String apellido,
                                                   @RequestParam(required = false) String correo,
                                                   @RequestParam(required = false) @DateTimeFormat(pattern="dd-MM-yyyy") Date fechaEntrada,
                                                   @RequestParam(required = false) String ciudad,
                                                   @RequestParam(required = false) Integer horasSemanales,
                                                   @RequestParam(required = false) String especialidad,
                                                   @RequestParam(required = false) String estado){

        HashMap<String, Object> data=new HashMap<>();

        if (nombre!=null)
            data.put("nombre",nombre);
        if (apellido!=null)
            data.put("apellido",apellido);
        if (correo!=null)
            data.put("correo",correo);
        if (fechaEntrada!=null)
            data.put("fechaEntrada",fechaEntrada);
        if (ciudad!=null)
            data.put("ciudad",ciudad);
        if (horasSemanales!=null)
            data.put("horasSemanales",horasSemanales);
        if (especialidad!=null)
            data.put("especialidad",especialidad);
        if (estado!=null)
            data.put("estado",estado);

       return findByAnyEstudiantePort.listaPersonalizada2(data);
    }
}
