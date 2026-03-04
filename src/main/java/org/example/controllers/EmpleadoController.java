package org.example.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.models.dto.EmpleadoResponse;
import org.example.models.dto.EmpledoRequest;
import org.example.services.EmpleadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
@RequiredArgsConstructor
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @GetMapping
    public ResponseEntity<List<EmpleadoResponse>> listar(){
        return ResponseEntity.ok(empleadoService.obtenerTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<EmpleadoResponse> listarPorId(@PathVariable  String id){
        return ResponseEntity.ok(empleadoService.obtenerPorId(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<EmpleadoResponse> actualizar(@PathVariable  String id, @Valid @RequestBody EmpledoRequest empledoRequest){
        return ResponseEntity.ok(empleadoService.actualizar(id, empledoRequest));
    }

    @PostMapping
    public ResponseEntity<EmpleadoResponse> crear(@RequestBody EmpledoRequest empledoRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoService.crear(empledoRequest));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id){
        empleadoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
