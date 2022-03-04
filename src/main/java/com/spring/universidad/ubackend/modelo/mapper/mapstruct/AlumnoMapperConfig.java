package com.spring.universidad.ubackend.modelo.mapper.mapstruct;

import com.spring.universidad.ubackend.modelo.dto.AlumnoDTO;
import com.spring.universidad.ubackend.modelo.entidades.Alumno;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface AlumnoMapperConfig extends PersonaMapperConfig{

    @InheritConfiguration(name = "mapPersona")
    void mapAlumno(Alumno alumno, @MappingTarget AlumnoDTO alumnoDTO);
}
