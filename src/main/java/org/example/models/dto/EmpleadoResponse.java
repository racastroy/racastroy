package org.example.models.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class EmpleadoResponse {

    private String id;
    private String nombreCompleto;
    private Integer edad;
    private String sexo;
    private LocalDate fechaNacimiento;
    private  String puesto;
}


