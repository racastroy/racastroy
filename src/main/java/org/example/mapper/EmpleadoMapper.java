package org.example.mapper;

import org.example.models.dto.EmpleadoResponse;
import org.example.models.dto.EmpledoRequest;
import org.example.models.entity.Empleado;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoMapper {

    public Empleado toEntity(EmpledoRequest request){
        return Empleado.builder().primerNombre(request.getPrimerNombre())
                .segundoNombre(request.getSegundoNombre())
                .apellidoPaterno(request.getApellidoPaterno())
                .apellidoMaterno(request.getApellidoMaterno())
                .edad(request.getEdad())
                .sexo(request.getSexo())
                .fechaNacimiento(request.getFechaNacimiento())
                .puesto(request.getPuesto())
                .build();
    }

    public EmpleadoResponse toResponse(Empleado empleado){
        return EmpleadoResponse.builder()
                .id(empleado.getId())
                .nombreCompleto(empleado.getPrimerNombre() + " " +
                        empleado.getApellidoPaterno() + " " +
                        empleado.getApellidoMaterno())
                .edad(empleado.getEdad())
                .sexo(empleado.getSexo())
                .fechaNacimiento(empleado.getFechaNacimiento())
                .puesto(empleado.getPuesto()).build();
    }
}
