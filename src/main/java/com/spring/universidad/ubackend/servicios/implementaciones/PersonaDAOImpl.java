package com.spring.universidad.ubackend.servicios.implementaciones;

import com.spring.universidad.ubackend.modelo.entidades.Persona;
import com.spring.universidad.ubackend.repositorios.PersonaRepository;
import com.spring.universidad.ubackend.servicios.contratos.PersonaDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public class PersonaDAOImpl extends GenericDAOImpl<Persona, PersonaRepository> implements PersonaDAO {


    public PersonaDAOImpl(PersonaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido) {
        return repository.buscarPorNombreYApellido(nombre,apellido);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscarPorDni(String id) {
        return repository.buscarPorDni(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> buscarPersonaPorApellido(String apellido) {
        return repository.buscarPersonaPorApellido(apellido);
    }
}
