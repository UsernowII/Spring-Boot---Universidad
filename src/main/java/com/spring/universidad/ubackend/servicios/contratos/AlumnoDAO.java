package com.spring.universidad.ubackend.servicios.contratos;


import com.spring.universidad.ubackend.modelo.entidades.Persona;

public interface AlumnoDAO extends PersonaDAO{

    Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre);
}
