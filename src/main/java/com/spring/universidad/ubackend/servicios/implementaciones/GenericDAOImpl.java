package com.spring.universidad.ubackend.servicios.implementaciones;

import com.spring.universidad.ubackend.servicios.contratos.GenericDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class GenericDAOImpl <T, R extends CrudRepository <T, Integer>> implements GenericDAO <T> {

    protected final R repository; // puedo acceder sin necesidad del getter

    public GenericDAOImpl(R repository) {
        this.repository = repository;
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<T> finById(Integer id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public T save(T entidad) {
        return repository.save(entidad);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<T> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional()
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
