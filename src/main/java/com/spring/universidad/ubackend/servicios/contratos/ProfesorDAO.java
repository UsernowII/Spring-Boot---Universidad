package com.spring.universidad.ubackend.servicios.contratos;

import com.spring.universidad.ubackend.modelo.entidades.Persona;


public interface ProfesorDAO extends PersonaDAO{

    Iterable<Persona> findProfesoresByCarrera(String carrera);
}
