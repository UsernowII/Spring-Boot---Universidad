package com.spring.universidad.ubackend.servicios.contratos;

import com.spring.universidad.ubackend.modelo.entidades.Carrera;


public interface CarreraDAO extends GenericDAO<Carrera>{


    Iterable<Carrera> findCarrerasByNombreContains(String nombre);

    Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);

    Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidad);

    Iterable<Carrera> buscarCarrerasPorProfesorNombreYApellido(String nombre, String apellido);
}
