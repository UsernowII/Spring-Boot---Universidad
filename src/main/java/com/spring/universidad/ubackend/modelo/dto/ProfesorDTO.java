package com.spring.universidad.ubackend.modelo.dto;

import com.spring.universidad.ubackend.modelo.entidades.Direccion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.math.BigDecimal;

@NoArgsConstructor
public class ProfesorDTO extends PersonaDTO{

    @Getter @Setter
    private BigDecimal sueldo;

    public ProfesorDTO(Integer id, String nombre, String apellido,String dni,
                       Direccion direccion, BigDecimal sueldo) {
        super(id, nombre, apellido, dni, direccion);
        this.sueldo = sueldo;
    }
}
