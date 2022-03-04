package com.spring.universidad.ubackend.servicios.implementaciones;

import com.spring.universidad.ubackend.modelo.entidades.Persona;

import com.spring.universidad.ubackend.repositorios.PersonaRepository;
import com.spring.universidad.ubackend.repositorios.ProfesorRepository;
import com.spring.universidad.ubackend.servicios.contratos.ProfesorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProfesorDAOImpl extends PersonaDAOImpl implements ProfesorDAO {


    @Autowired
    public ProfesorDAOImpl(@Qualifier("repositorioProfesores") PersonaRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Persona> findProfesoresByCarrera(String carrera) {
        return ((ProfesorRepository)repository).findProfesoresByCarrera(carrera);
    }
}
