package com.spring.universidad.ubackend.controlador.dto;

import com.spring.universidad.ubackend.modelo.dto.PersonaDTO;
import com.spring.universidad.ubackend.modelo.entidades.Alumno;
import com.spring.universidad.ubackend.modelo.entidades.Empleado;
import com.spring.universidad.ubackend.modelo.entidades.Persona;
import com.spring.universidad.ubackend.modelo.entidades.Profesor;
import com.spring.universidad.ubackend.modelo.mapper.mapstruct.AlumnoMapper;
import com.spring.universidad.ubackend.servicios.contratos.PersonaDAO;

public class PersonaDtoController extends GenericDtoController<Persona, PersonaDAO>{

    protected final AlumnoMapper alumnoMapper;

    public PersonaDtoController(PersonaDAO service, String nombreEntidad, AlumnoMapper alumnoMapper) {
        super(service, nombreEntidad);
        this.alumnoMapper = alumnoMapper;
    }

    public PersonaDTO altaPersona(Persona persona){
        Persona pEntidad = super.altaEntidad(persona);
        PersonaDTO dto = null;
        if (pEntidad instanceof Alumno){
            dto = alumnoMapper.mapAlumno((Alumno) pEntidad);
        }else if (pEntidad instanceof Profesor){
            //aplicar mapper de profesor
        }else if (pEntidad instanceof Empleado){
            //aplicar mapper de Empleado
        }

        return dto;
    }
}
