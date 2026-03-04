package org.example.services.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.mapper.EmpleadoMapper;
import org.example.models.dto.EmpleadoResponse;
import org.example.models.dto.EmpledoRequest;
import org.example.models.entity.Empleado;
import org.example.models.repository.EmpleadoRepository;
import org.example.services.EmpleadoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;
    private final EmpleadoMapper mapper;

    @Override
    public List<EmpleadoResponse> obtenerTodos() {
        log.info("Obteniendo empleados");
        return empleadoRepository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public EmpleadoResponse obtenerPorId(String id) {
        Empleado empleado = empleadoRepository.findById(id).orElseThrow();
        return  mapper.toResponse(empleado);
    }

    @Override
    public EmpleadoResponse crear(EmpledoRequest request) {
        Empleado empleado = mapper.toEntity(request);

        return mapper.toResponse(empleadoRepository.save(empleado));
    }

    @Override
    public EmpleadoResponse actualizar(String id, EmpledoRequest request) {
        Empleado empleadoExistente = empleadoRepository.findById(id).orElseThrow();

        empleadoExistente.setPrimerNombre(request.getPrimerNombre());
        empleadoExistente.setSegundoNombre(request.getSegundoNombre());
        empleadoExistente.setApellidoPaterno(request.getApellidoPaterno());
        empleadoExistente.setApellidoMaterno(request.getApellidoMaterno());
        empleadoExistente.setEdad(request.getEdad());
        empleadoExistente.setSexo(request.getSexo());
        empleadoExistente.setFechaNacimiento(request.getFechaNacimiento());
        empleadoExistente.setPuesto(request.getPuesto());
        return mapper.toResponse(empleadoRepository.save(empleadoExistente));
    }

    @Override
    public void eliminar(String id) {
        empleadoRepository.deleteById(id);

    }
}
