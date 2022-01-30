package com.spring.universidad.ubackend.repositorios;

import com.spring.universidad.ubackend.modelo.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonaRepository extends CrudRepository<Persona, Integer> {


}
