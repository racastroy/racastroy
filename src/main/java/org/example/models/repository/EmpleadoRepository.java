package org.example.models.repository;

import org.example.models.entity.Empleado;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpleadoRepository extends MongoRepository<Empleado, String> {
}
