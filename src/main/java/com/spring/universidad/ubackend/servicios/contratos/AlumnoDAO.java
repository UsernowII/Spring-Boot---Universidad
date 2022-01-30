package com.spring.universidad.ubackend.servicios.contratos;


import com.spring.universidad.ubackend.modelo.Persona;

public interface AlumnoDAO extends PersonaDAO{

    Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre);
}
