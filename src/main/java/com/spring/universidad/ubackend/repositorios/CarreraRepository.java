package com.spring.universidad.ubackend.repositorios;

import com.spring.universidad.ubackend.modelo.entidades.Carrera;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository extends CrudRepository<Carrera, Integer> {

    //@Query("select c from Carrera as c where c.nombre like %?1%")
    Iterable<Carrera> findCarrerasByNombreContains(String nombre);
    //@Query("select c from Carrera as c where upper(c.nombre) like upper('%?1%') ")
    Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
    //@Query("select c from Carrera  as c where c.cantidadAnios >?1")
    Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);

    @Query("select c from Carrera as c join fetch c.profesores as p where p.nombre =?1 and p.apellido =?2")
    Iterable<Carrera> buscarCarrerasPorProfesorNombreYApellido(String nombre, String apellido);
}
