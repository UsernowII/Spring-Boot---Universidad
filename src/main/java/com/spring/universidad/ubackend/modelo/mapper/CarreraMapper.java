package com.spring.universidad.ubackend.modelo.mapper;

import com.spring.universidad.ubackend.modelo.dto.CarreraDTO;
import com.spring.universidad.ubackend.modelo.entidades.Carrera;

@Deprecated
public class CarreraMapper {

    public static CarreraDTO mapCarrera(Carrera carrera){
        CarreraDTO dto = new CarreraDTO();
        dto.setCodigo(carrera.getId());
        dto.setNombre(carrera.getNombre());
        dto.setCantidad_anios(carrera.getCantidadAnios());
        dto.setCantidad_materias(carrera.getCantidadMaterias());
        return dto;
    }
}
