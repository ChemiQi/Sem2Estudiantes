package com.example.Sem2Estudiantes.tiporegistro.domain;

import com.example.Sem2Estudiantes.student.configurations.StringPrefixedSequenceIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tiporegistro")
public class TipoRegistroJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_tiporegistro")
    @GenericGenerator(
            name = "id_tiporegistro",
            strategy = "com.example.Sem2Estudiantes.tiporegistro.configurations.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "EST"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            })

    String id_tipoRegistro;
    String name;
    Date last_update;
    Boolean activo;

}
