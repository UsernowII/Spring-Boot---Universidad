package com.spring.universidad.ubackend;

import com.spring.universidad.ubackend.modelo.Alumno;
import com.spring.universidad.ubackend.modelo.Carrera;
import com.spring.universidad.ubackend.modelo.Persona;
import com.spring.universidad.ubackend.servicios.contratos.AlumnoDAO;
import com.spring.universidad.ubackend.servicios.contratos.CarreraDAO;
import com.spring.universidad.ubackend.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AlumnosComandos implements CommandLineRunner {


    @Autowired
    @Qualifier("alumnoDAOImpl")
    private PersonaDAO personaDAO;
    @Autowired
    private CarreraDAO carreraDAO;

    @Override
    public void run(String... args) throws Exception {
        /*
        Optional<Carrera> ingSistemas = carreraDAO.finById(2);
        Iterable<Persona> alumnos =  personaDAO.findAll();
        alumnos.forEach( alumno ->{
            ((Alumno)alumno).setCarrera(ingSistemas.get());
        });
        alumnos.forEach(alumno -> personaDAO.save(alumno));

         */


        /*
        Optional<Persona> personaNombreApellido = personaDAO.buscarPorNombreYApellido(alumno_1.get().getNombre(), alumno_1.get().getApellido());
        System.out.println(personaNombreApellido.toString());

        Optional<Persona> personaDni = personaDAO.buscarPorDni(alumno_1.get().getDni());
        System.out.println(personaDni);

        Iterable<Persona> personasApellidos = personaDAO.buscarPersonaPorApellido(alumno_1.get().getApellido());
        personasApellidos.forEach(System.out::println);
         */

        /*
        Optional<Carrera> ingSistemas = carreraDAO.finById(2);
        Iterable<Persona> alumnosCarrera = ((AlumnoDAO) personaDAO).buscarAlumnosPorNombreCarrera(ingSistemas.get().getNombre());
        alumnosCarrera.forEach(System.out::println);

         */
    }
}

