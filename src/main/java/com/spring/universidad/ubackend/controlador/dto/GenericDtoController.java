package com.spring.universidad.ubackend.controlador.dto;

import com.spring.universidad.ubackend.servicios.contratos.GenericDAO;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class GenericDtoController <E, S extends GenericDAO<E> > {

    protected final S service;
    protected final String nombreEntidad;


    public List<E> obtenerTodos(){
        return (List<E>)service.findAll();
    }

    public E obtenerPorId(Integer id){
        return (E) service.finById(id);
    }

    public E altaEntidad(E entidad){
        return service.save(entidad);
    }

    protected Map<String, Object> getValidaciones(BindingResult result) {
        Map<String, Object> validaciones = new HashMap<>();
        result.getFieldErrors()
                .forEach( error -> validaciones.put(error.getField(), error.getDefaultMessage()));
        return validaciones;
    }

}
