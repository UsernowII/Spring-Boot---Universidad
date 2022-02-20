package com.spring.universidad.ubackend.repositorios;

import com.spring.universidad.ubackend.modelo.Persona;
import com.spring.universidad.ubackend.modelo.enumeradores.TipoEmpleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioEmpleados")
public interface EmpleadoRepository extends PersonaRepository{

    @Query("SELECT e FROM Empleado as e WHERE e.tipoEmpleado =?1")
    Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado);
}
