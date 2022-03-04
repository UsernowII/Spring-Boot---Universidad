package com.spring.universidad.ubackend.controlador;


import com.spring.universidad.ubackend.exception.BadRequestException;
import com.spring.universidad.ubackend.modelo.Alumno;
import com.spring.universidad.ubackend.modelo.Carrera;
import com.spring.universidad.ubackend.modelo.Persona;
import com.spring.universidad.ubackend.servicios.contratos.CarreraDAO;
import com.spring.universidad.ubackend.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController extends PersonaController {


    private final CarreraDAO carreraDAO;

    @Autowired
    public AlumnoController(@Qualifier("alumnoDAOImpl") PersonaDAO alumnoDao, CarreraDAO carreraDAO) {
        super(alumnoDao);
        nombreEntidad = "Alumno";
        this.carreraDAO = carreraDAO;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarAlumno(@PathVariable Integer id, @RequestBody Persona alumno) {
        Map<String , Object> mensaje = new HashMap<>();
        Persona alumnoUpdate;
        Optional<Persona> oPersona = service.finById(id);
        if (oPersona.isEmpty()) {
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("Alumno con id %d no existe", id));
            return ResponseEntity.badRequest().body(mensaje);
        }
        alumnoUpdate = oPersona.get();
        alumnoUpdate.setNombre(alumno.getNombre());
        alumnoUpdate.setApellido(alumno.getApellido());
        alumnoUpdate.setDireccion(alumno.getDireccion());
        mensaje.put("datos", service.save(alumnoUpdate));
        mensaje.put("success", Boolean.TRUE);
        return ResponseEntity.ok(mensaje);
    }


    @PutMapping("/{idAlumno}/carrera/{idCarrera}")
    public ResponseEntity<?> asignarCarreraAlumno(@PathVariable Integer idAlumno, @PathVariable Integer idCarrera){
        Map<String , Object> mensaje = new HashMap<>();
        Optional<Persona> oAlumno = service.finById(idAlumno);
        if (!oAlumno.isPresent()) {
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("Alumno con id %d no existe", idAlumno));
            return ResponseEntity.badRequest().body(mensaje);
        }
        Optional<Carrera> oCarrera = carreraDAO.finById(idCarrera);
        if (oCarrera.isEmpty()){
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje",String.format("Carrera con id %d no existe", idCarrera));
            return ResponseEntity.badRequest().body(mensaje);
        }
        Persona alumno = oAlumno.get();
        Carrera carrera = oCarrera.orElseThrow();

        ((Alumno)alumno).setCarrera(carrera);
        mensaje.put("datos", service.save(alumno));
        mensaje.put("success", Boolean.TRUE);
        return ResponseEntity.accepted().body(mensaje);
    }

    /*
    @GetMapping()
    public List<Persona> obtenerTodos() {
        List<Persona> alumnos = (List<Persona>) alumnoDao.findAll();
        if (alumnos.isEmpty()) {
            throw new BadRequestException("No existen alumnos");
        }
        return alumnos;
    }

    @GetMapping("/{id}")
    public Persona obtenerAlumnoPorId(@PathVariable Integer id) {
        Optional<Persona> oAlumno = alumnoDao.finById(id);
        if (oAlumno.isPresent()) {
            return oAlumno.orElseThrow();

        }
        throw new BadRequestException(String.format("Alumno con id %d no existe", id));
    }

    @PostMapping()
    public Persona altaAlumno(@RequestBody Persona alumno) {
        return alumnoDao.save(alumno);
    }

       @PutMapping("/{id}")
    public Persona actualizarAlumno(@PathVariable Integer id, @RequestBody Persona alumno) {
        Persona alumnoUpdate;
        Optional<Persona> oPersona = service.finById(id);
        if (oPersona.isEmpty()) {
            throw new BadRequestException(String.format("Alumno con id %d no existe", id));
        }
        alumnoUpdate = oPersona.get();
        alumnoUpdate.setNombre(alumno.getNombre());
        alumnoUpdate.setApellido(alumno.getApellido());
        alumnoUpdate.setDireccion(alumno.getDireccion());
        return service.save(alumnoUpdate);
    }

    @DeleteMapping("/{id}")
    public void eliminarAlumno(@PathVariable Integer id){
        alumnoDao.deleteById(id);
    }
     */

}
