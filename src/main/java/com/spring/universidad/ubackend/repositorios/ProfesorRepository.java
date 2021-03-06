package com.spring.universidad.ubackend.repositorios;

import com.spring.universidad.ubackend.modelo.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository("repositorioProfesores")
public interface ProfesorRepository extends PersonaRepository{

    @Query("select p from Profesor as p join fetch p.carreras as c where c.nombre =?1")
    Iterable<Persona> findProfesoresByCarrera(String carrera);
}
