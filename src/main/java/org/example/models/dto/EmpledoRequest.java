package org.example.models.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmpledoRequest {

    @NotBlank
    private String id;
    private String primerNombre;
    private String segundoNombre;
    @NotBlank
    private String apellidoPaterno;
    private String apellidoMaterno;

    @Min(18)
    private Integer edad;
    @NotBlank
    private String sexo;
    @NotNull
    private LocalDate fechaNacimiento;
    @NotBlank
    private  String puesto;
}
