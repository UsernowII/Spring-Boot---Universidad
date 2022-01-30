package com.spring.universidad.ubackend.repositorios;

import com.spring.universidad.ubackend.modelo.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositorioAlumnos")
public interface AlumnoRepository extends PersonaRepository{

        @Query("select a from Alumno as a where a.carrera.nombre = ?1")
        Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre);
}
