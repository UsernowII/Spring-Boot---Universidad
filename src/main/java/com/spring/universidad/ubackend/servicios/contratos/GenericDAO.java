package com.spring.universidad.ubackend.servicios.contratos;


import java.util.Optional;

public interface GenericDAO<T> {

    Optional<T> finById(Integer id);

    T save (T entidad);

    Iterable<T> findAll();

    void deleteById(Integer id);
}
