package com.spring.universidad.ubackend.repositorios;

import com.spring.universidad.ubackend.modelo.Alumno;
import com.spring.universidad.ubackend.modelo.Carrera;
import com.spring.universidad.ubackend.modelo.Persona;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static com.spring.universidad.ubackend.datos.DatosDummy.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AlumnoRepositoryTest {

    @Autowired
    @Qualifier("repositorioAlumnos")
    PersonaRepository alumnoRepo;

    @Autowired
    CarreraRepository carreraRepository;

    @Test
    void buscarAlumnosPorNombreCarrera() {
        //Given

        Iterable<Persona> personas = alumnoRepo.saveAll(Arrays.asList
                (alumno01(), alumno02(), alumno03())
        );

        Carrera save = carreraRepository.save(carrera01());

        personas.forEach(alumno -> ((Alumno)alumno).setCarrera(save));

        alumnoRepo.saveAll(personas);

        //when
        String carreraNombre = "Ingenieria en sistemas";
        List<Persona> expected = (List<Persona>) ((AlumnoRepository) alumnoRepo).buscarAlumnosPorNombreCarrera(carreraNombre);

        //then

        assertThat(expected.size() == 3).isTrue();
    }

    @Test
    void buscarAlumnosPorNombreCarreraSinValores() {
        //Given

        Iterable<Persona> personas = alumnoRepo.saveAll(Arrays.asList
                (alumno01(), alumno02(), alumno03())
        );

        Carrera save = carreraRepository.save(carrera01());

        personas.forEach(alumno -> ((Alumno)alumno).setCarrera(save));

        alumnoRepo.saveAll(personas);

        //when
        String carreraNombre = "Ingenieria en Alimentos";
        List<Persona> expected = (List<Persona>) ((AlumnoRepository) alumnoRepo).buscarAlumnosPorNombreCarrera(carreraNombre);

        //then

        assertThat(expected.isEmpty()).isTrue();
    }

}