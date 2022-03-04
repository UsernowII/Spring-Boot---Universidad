package com.spring.universidad.ubackend.servicios.contratos;

import com.spring.universidad.ubackend.modelo.entidades.Persona;

import java.util.Optional;

public interface PersonaDAO extends GenericDAO<Persona>{

    Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);

    Optional<Persona> buscarPorDni(String id);

    Iterable<Persona> buscarPersonaPorApellido(String apellido);

}
