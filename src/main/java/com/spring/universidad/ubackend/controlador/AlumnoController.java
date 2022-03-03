package com.spring.universidad.ubackend.controlador;


import com.spring.universidad.ubackend.exception.BadRequestException;
import com.spring.universidad.ubackend.modelo.Alumno;
import com.spring.universidad.ubackend.modelo.Carrera;
import com.spring.universidad.ubackend.modelo.Persona;
import com.spring.universidad.ubackend.servicios.contratos.CarreraDAO;
import com.spring.universidad.ubackend.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {


    private final PersonaDAO alumnoDao;
    private final CarreraDAO carreraDAO;

    @Autowired
    public AlumnoController(@Qualifier("alumnoDAOImpl") PersonaDAO alumnoDao, CarreraDAO carreraDAO) {
        this.alumnoDao = alumnoDao;
        this.carreraDAO = carreraDAO;
    }


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
        Optional<Persona> oPersona = alumnoDao.finById(id);
        if (oPersona.isEmpty()) {
            throw new BadRequestException(String.format("Alumno con id %d no existe", id));
        }
        alumnoUpdate = oPersona.get();
        alumnoUpdate.setNombre(alumno.getNombre());
        alumnoUpdate.setApellido(alumno.getApellido());
        alumnoUpdate.setDireccion(alumno.getDireccion());
        return alumnoDao.save(alumnoUpdate);
    }


    @DeleteMapping("/{id}")
    public void eliminarAlumno(@PathVariable Integer id){
        alumnoDao.deleteById(id);
    }

    @PutMapping("/{idAlumno}/carrera/{idCarrera}")
    public Persona asignarCarreraAlumno(@PathVariable Integer idAlumno, @PathVariable Integer idCarrera){
        Optional<Persona> oAlumno = alumnoDao.finById(idAlumno);
        if (!oAlumno.isPresent()) {
            throw new BadRequestException(String.format("Alumno con id %d no existe", idAlumno));
        }
        Optional<Carrera> oCarrera = carreraDAO.finById(idCarrera);
        if (oCarrera.isEmpty()){
            throw new BadRequestException(String.format("Carrera con id %d no existe", idCarrera));
        }
        Persona alumno = oAlumno.get();
        Carrera carrera = oCarrera.orElseThrow();

        ((Alumno)alumno).setCarrera(carrera);
        return alumnoDao.save(alumno);
    }
}
