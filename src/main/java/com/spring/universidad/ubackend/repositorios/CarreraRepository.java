package com.spring.universidad.ubackend.repositorios;

import com.spring.universidad.ubackend.modelo.Carrera;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository extends CrudRepository<Carrera, Integer> {


}
