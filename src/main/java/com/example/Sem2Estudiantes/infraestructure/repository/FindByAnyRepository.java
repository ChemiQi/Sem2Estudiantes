package com.example.Sem2Estudiantes.infraestructure.repository;


import com.example.Sem2Estudiantes.domain.EstudianteJpa;
import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoOutput;
import com.example.Sem2Estudiantes.infraestructure.repository.jpa.EstudianteRepository;
import com.example.Sem2Estudiantes.infraestructure.repository.port.FindByAnyEstudiantePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Repository
public class FindByAnyRepository implements FindByAnyEstudiantePort {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
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

    @Override
    public List<EstudianteJpa> listaPersonalizada2(HashMap<String, Object> conditions){
        //TODO recibir un DTO de input. No usar HashMap
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<EstudianteJpa> query = criteriaBuilder.createQuery(EstudianteJpa.class);
        Root<EstudianteJpa> root = query.from(EstudianteJpa.class);

        addPredicate(name,dfkdm)

         if (name!=null)
             predicates.add(criteriaBuilder.like(root.get("name"),name));

        List<Predicate> predicates = new ArrayList<>();
        conditions.forEach((field, value) -> {
            switch (field){
                case "nombre":
                    predicates.add(criteriaBuilder.like(root.get(field),(String)value));
                    break;
                default:
                    predicates.add(criteriaBuilder.like(root.get(field),"%"+(String)value+"%"));
                    break;
                case "fechaEntrada":
                    predicates.add(criteriaBuilder.like(root.get(field),"%"+(Date)value+"%"));
                    break;
                case "horasSemanales":
                    predicates.add(criteriaBuilder.like(root.get(field),"%"+(Integer)value+"%"));
                    break;
            }
        });
        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(query).getResultList();
    }

}
