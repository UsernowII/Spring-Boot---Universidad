package com.spring.universidad.ubackend.modelo.mapper.mapstruct;

import com.spring.universidad.ubackend.modelo.dto.PersonaDTO;
import com.spring.universidad.ubackend.modelo.entidades.Persona;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig // se configura para decir que es una herencia de persona y se mapea al DTO
public interface PersonaMapperConfig {

    void mapPersona(Persona persona, @MappingTarget PersonaDTO personaDTO);
}
