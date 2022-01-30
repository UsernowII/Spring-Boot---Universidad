package com.spring.universidad.ubackend.servicios.contratos;

import com.spring.universidad.ubackend.modelo.Carrera;


public interface CarreraDAO extends GenericDAO<Carrera>{

    //@Query("select c from Carrera as c where c.nombre like %?1%")
    Iterable<Carrera> findCarrerasByNombreContains(String nombre);
    //@Query("select c from Carrera as c where upper(c.nombre) like upper('%?1%') ")
    Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
    //@Query("select c from Carrera  as c where c.cantidadAnios >?1")
    Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidad);
}
