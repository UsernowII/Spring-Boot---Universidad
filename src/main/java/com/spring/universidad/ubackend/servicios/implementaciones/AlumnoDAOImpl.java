package com.spring.universidad.ubackend.servicios.implementaciones;

import com.spring.universidad.ubackend.modelo.Persona;
import com.spring.universidad.ubackend.repositorios.AlumnoRepository;
import com.spring.universidad.ubackend.repositorios.PersonaRepository;
import com.spring.universidad.ubackend.servicios.contratos.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class AlumnoDAOImpl extends PersonaDAOImpl implements AlumnoDAO {

    /*@Autowired
    @Qualifier("repositorioAlumnos")
    private PersonaRepository repository;
    Para especificar que esta usando un repo en herencia
     */

    @Autowired
    public AlumnoDAOImpl(@Qualifier("repositorioAlumnos")PersonaRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre) {
        return ((AlumnoRepository)repository).buscarAlumnosPorNombreCarrera(nombre);
    }
}
