package com.example.Sem2Estudiantes.tiporegistro.infraestructure.repository.jpa;


import com.example.Sem2Estudiantes.tiporegistro.domain.TipoRegistroJpa;
import org.springframework.data.repository.CrudRepository;

public interface TipoRegistroRepository extends CrudRepository<TipoRegistroJpa,String> {
}
