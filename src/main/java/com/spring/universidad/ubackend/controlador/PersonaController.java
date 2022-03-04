package com.spring.universidad.ubackend.controlador;

import com.spring.universidad.ubackend.exception.BadRequestException;
import com.spring.universidad.ubackend.modelo.Persona;
import com.spring.universidad.ubackend.servicios.contratos.PersonaDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PersonaController extends GenericController <Persona, PersonaDAO>{


    public PersonaController(PersonaDAO service) {
        super(service);
    }

    @GetMapping("/nombre-apellido")
    public ResponseEntity<?> buscarPersonaPorNombreYApellido(@RequestParam String nombre, @RequestParam String apellido){
        Map<String , Object> mensaje = new HashMap<>();
        Optional<Persona> oPersona = service.buscarPorNombreYApellido(nombre, apellido);
        if (oPersona.isEmpty()){
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje",
                    String.format("No se encontro persona con nombre %s y apellido %s",nombre, apellido));
            return ResponseEntity.badRequest().body(mensaje);
        }

        mensaje.put("success", Boolean.TRUE);
        mensaje.put("datos",oPersona.orElseThrow() );
        return ResponseEntity.ok(mensaje);
    }
}
