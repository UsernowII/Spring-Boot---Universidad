package com.spring.universidad.ubackend.repositorios;

import com.spring.universidad.ubackend.modelo.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean // no Genere un bean de este repo pero si de las clases hijas
public interface PersonaRepository extends CrudRepository<Persona, Integer> {

    @Query("select p from Persona as p where p.nombre =?1 and p.apellido =?2")
    Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);

    @Query("select p from Persona as p where p.dni = ?1")
    Optional<Persona> buscarPorDni(String id);

    @Query("select p from Persona as p where p.apellido like %?1%")
    Iterable<Persona> buscarPersonaPorApellido(String apellido);

}
