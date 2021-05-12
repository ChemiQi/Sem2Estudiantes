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
    public List<EstudianteJpa> buscarPorParametros(@RequestParam(required = false) String name,
                                                   @RequestParam(required = false) String apellido,
                                                   @RequestParam(required = false) String correo,
                                                   @RequestParam(required = false) String personal_email,
                                                   @RequestParam(required = false) @DateTimeFormat(pattern="dd-MM-yyyy") Date createDate,
                                                   @RequestParam(required = false) String city,
                                                   @RequestParam(required = false) Integer numHoursWeek){

        HashMap<String, Object> data=new HashMap<>();

        if (name!=null)
            data.put("name",name);
        if (apellido!=null)
            data.put("surname",apellido);
        if (correo!=null)
            data.put("company_email",correo);
        if (personal_email!=null)
            data.put("personal_email",personal_email);
        if (createDate!=null)
            data.put("createDate",createDate);
        if (city!=null)
            data.put("city",city);
        if (numHoursWeek!=null)
            data.put("numHoursWeek",numHoursWeek);

       return findByAnyEstudiantePort.listaPersonalizada2(data);
    }
    /*@GetMapping
    public List<EstudianteDtoOutput> buscarPorParametros(@RequestParam String nombreColumna, @RequestParam String datoColumna){
        return findByAnyEstudiantePort.listaPersonalizada(nombreColumna,datoColumna);
    }*/

}
