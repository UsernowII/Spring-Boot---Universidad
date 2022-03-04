package com.spring.universidad.ubackend.servicios.contratos;


import com.spring.universidad.ubackend.modelo.entidades.Persona;
import com.spring.universidad.ubackend.modelo.enumeradores.TipoEmpleado;

public interface EmpleadoDAO extends PersonaDAO{

    Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado);
}
