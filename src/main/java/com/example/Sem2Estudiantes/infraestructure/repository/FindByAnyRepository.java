package com.example.Sem2Estudiantes.infraestructure.repository;


import com.example.Sem2Estudiantes.domain.EstudianteJpa;
import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoOutput;
import com.example.Sem2Estudiantes.infraestructure.repository.jpa.EstudianteRepository;
import com.example.Sem2Estudiantes.infraestructure.repository.port.FindByAnyEstudiantePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class FindByAnyRepository implements FindByAnyEstudiantePort {

    @Autowired
    EstudianteRepository estudianteRepository;

    public List<EstudianteDtoOutput> listaPersonalizada(String nombre_tabla, String parametro){

        List<EstudianteDtoOutput> listaDeVueltaEstudianteDtoOutput = new ArrayList<>();

        HashMap<String,Object> hm = new HashMap<>();
        hm.put(nombre_tabla,parametro);
        List<EstudianteJpa> listaPersonalizaEstudianteJpa = estudianteRepository.getData(hm);

        for(EstudianteJpa estudianteJpa : listaPersonalizaEstudianteJpa){
            listaDeVueltaEstudianteDtoOutput.add(new EstudianteDtoOutput(estudianteJpa));
        }

        return listaDeVueltaEstudianteDtoOutput;
    }

}
