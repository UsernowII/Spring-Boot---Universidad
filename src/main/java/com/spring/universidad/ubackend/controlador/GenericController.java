package com.spring.universidad.ubackend.controlador;

import com.spring.universidad.ubackend.exception.BadRequestException;
import com.spring.universidad.ubackend.servicios.contratos.GenericDAO;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class GenericController <E, S extends GenericDAO <E> >{

    protected final S service;
    protected String nombreEntidad;


    public GenericController(S service) {
        this.service = service;
    }

    @GetMapping()
    public List<E> obtenerTodos(){
        List<E> listado = (List<E>) service.findAll();
        if (listado.isEmpty()){
            throw new BadRequestException(String.format("No se han encontrado %ss", nombreEntidad));
        }
        return listado;
    }

    public E findById(Integer id){
        return new E;
    }
}
