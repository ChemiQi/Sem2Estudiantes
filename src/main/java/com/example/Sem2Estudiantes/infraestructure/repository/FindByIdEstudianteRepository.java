package com.example.Sem2Estudiantes.infraestructure.repository;

import com.example.Sem2Estudiantes.domain.EstudianteJpa;
import com.example.Sem2Estudiantes.infraestructure.controller.dto.EstudianteDtoOutput;
import com.example.Sem2Estudiantes.infraestructure.repository.jpa.EstudianteRepository;
import com.example.Sem2Estudiantes.infraestructure.repository.port.FindByIdEstudiantePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class FindByIdEstudianteRepository implements FindByIdEstudiantePort {

    @Autowired
    private JdbcOperations jdbc;

    @Override
    public EstudianteDtoOutput findByIdEstudiante(Integer id) {
            return obtenerEstudianteDtoOutputByIdEstudiante(id);
    }

    private EstudianteDtoOutput obtenerEstudianteDtoOutputByIdEstudiante(Integer id){
        EstudianteJpa estudianteEncontrado = jdbc.queryForObject("select * from Estudiante_Jpa where id= ?",new estudianteRowMapper(),id);
        return new EstudianteDtoOutput(estudianteEncontrado);

        /*Optional<EstudianteJpa> estudianteJpaOptional = estudianteRepository.findById(id);
        if(estudianteJpaOptional.isPresent()){

            return new EstudianteDtoOutput(estudianteJpaOptional.get());
        }else{
            return null;
        }*/
    }

    private class estudianteRowMapper implements RowMapper<EstudianteJpa>{

        @Override
        public EstudianteJpa mapRow(ResultSet resultSet, int i) throws SQLException {
            return new EstudianteJpa(
                    resultSet.getInt("id"),
                    resultSet.getString("nombre"),
                    resultSet.getString("apellido"),
                    resultSet.getString("correo"),
                    //new java.util.Date(resultSet.getTime("fechaEntrada")),
                    resultSet.getDate("fechaEntrada"),
                    resultSet.getString("ciudad"),
                    resultSet.getDouble("horasSemanales"),
                    resultSet.getString("especialidad"),
                    resultSet.getString("estado")
            );
        }
    }

}


