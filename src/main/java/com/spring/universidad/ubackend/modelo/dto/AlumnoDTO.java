package com.spring.universidad.ubackend.modelo.dto;

import com.spring.universidad.ubackend.modelo.entidades.Direccion;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AlumnoDTO extends PersonaDTO{

    public AlumnoDTO(Integer id, String nombre, String apellido,String dni, Direccion direccion) {
        super(id, nombre, apellido, dni, direccion);
    }
}
