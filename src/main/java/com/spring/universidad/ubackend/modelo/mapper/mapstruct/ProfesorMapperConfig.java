package com.spring.universidad.ubackend.modelo.mapper.mapstruct;

import com.spring.universidad.ubackend.modelo.dto.ProfesorDTO;
import com.spring.universidad.ubackend.modelo.entidades.Profesor;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface ProfesorMapperConfig extends PersonaMapperConfig{

    @InheritConfiguration(name = "mapPersona")
    void mapProfesor(Profesor profesor, @MappingTarget ProfesorDTO profesorDTO);
}
