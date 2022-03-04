package com.spring.universidad.ubackend.controlador.dto;

import com.spring.universidad.ubackend.modelo.dto.AlumnoDTO;
import com.spring.universidad.ubackend.modelo.dto.PersonaDTO;
import com.spring.universidad.ubackend.modelo.mapper.mapstruct.AlumnoMapper;
import com.spring.universidad.ubackend.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "true")
@RestController
@RequestMapping("/alumnos")
public class AlumnoDtoController extends PersonaDtoController {



    public AlumnoDtoController(@Qualifier("alumnoDAOImpl") PersonaDAO service, AlumnoMapper alumnoMapper) {
        super(service,"Alumno", alumnoMapper);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerAlumnoPorId(@PathVariable Integer id){
        Map<String, Object> mensaje = new HashMap<>();
        //Optional<Persona> oPersona = personaDAO.finById(id);
        //PersonaDTO dto = mapper.mapAlumno((Alumno) oPersona.get());
        mensaje.put("success", Boolean.FALSE);
        //mensaje.put("data", dto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensaje);
    }

    @PostMapping
    public ResponseEntity<?> altaAlumno(@Valid @RequestBody PersonaDTO personaDTO, BindingResult result){
        Map<String, Object> mensaje = new HashMap<>();
        if (result.hasErrors()){
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("validaciones", super.getValidaciones(result));
            return ResponseEntity.badRequest().body(mensaje);
        }

        PersonaDTO alumno = super.altaPersona(alumnoMapper.mapAlumno((AlumnoDTO) personaDTO));
        mensaje.put("success", Boolean.TRUE);
        mensaje.put("data", alumno);

        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);

    }


}
