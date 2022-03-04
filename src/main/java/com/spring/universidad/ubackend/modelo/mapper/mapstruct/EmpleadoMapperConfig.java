package com.spring.universidad.ubackend.modelo.mapper.mapstruct;

import com.spring.universidad.ubackend.modelo.dto.EmpleadoDTO;
import com.spring.universidad.ubackend.modelo.entidades.Empleado;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface EmpleadoMapperConfig extends PersonaMapperConfig{

    @InheritConfiguration(name = "mapPersona")
    void mapEmpleado(Empleado empleado, @MappingTarget EmpleadoDTO empleadoDTO);
}
