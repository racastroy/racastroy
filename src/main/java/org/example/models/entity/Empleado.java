package org.example.models.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "empleados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empleado {

    private String id;
    private String primerNombre;
    private String segundoNombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Integer edad;
    private String sexo;
    private LocalDate fechaNacimiento;
    private  String puesto;
}
