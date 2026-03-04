package org.example.services;

import org.example.models.dto.EmpleadoResponse;
import org.example.models.dto.EmpledoRequest;

import java.util.List;

public interface EmpleadoService {

    List<EmpleadoResponse> obtenerTodos();
    EmpleadoResponse obtenerPorId(String id);
    EmpleadoResponse crear(EmpledoRequest request);
    EmpleadoResponse actualizar(String id, EmpledoRequest request);
    void eliminar(String id);

}
