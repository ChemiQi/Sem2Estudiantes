package com.example.Sem2Estudiantes.infraestructure.repository.jpa;

import com.example.Sem2Estudiantes.domain.EstudianteJpa;

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

public class EstudianteRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public List<EstudianteJpa> getData(HashMap<String,Object> conditions){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<EstudianteJpa> query= cb.createQuery(EstudianteJpa.class);
        Root<EstudianteJpa> root = query.from(EstudianteJpa.class);

        List<Predicate> predicates = new ArrayList<>();
        conditions.forEach((field,value) ->
        {
            switch (field)
            {
                case "id":
                    predicates.add(cb.equal (root.get(field), (Integer)value));
                    break;
                case "nombre":
                    predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
                    break;
                case "apellido":
                    predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
                    break;
                case "correo":
                    predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
                    break;
                case "fechaEntrada":
                    predicates.add(cb.like(root.get(field),"%"+(Date)value+"%"));
                    break;
                case "ciudad":
                    predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
                    break;
                case "horasSemanales":
                    predicates.add(cb.like(root.get(field),"%"+(double)value+"%"));
                    break;
                case "especialidad":
                    predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
                    break;
                case "estado":
                    predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
                    break;
            }
        });
        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(query).getResultList();
    }
}
