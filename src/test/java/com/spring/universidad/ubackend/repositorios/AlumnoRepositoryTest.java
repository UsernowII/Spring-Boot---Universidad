package com.spring.universidad.ubackend.repositorios;

import com.spring.universidad.ubackend.modelo.entidades.Alumno;
import com.spring.universidad.ubackend.modelo.entidades.Carrera;
import com.spring.universidad.ubackend.modelo.entidades.Persona;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static com.spring.universidad.ubackend.datos.DatosDummy.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

        Carrera save = carreraRepository.save(carrera01(false));

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

        Carrera save = carreraRepository.save(carrera01(false));

        personas.forEach(alumno -> ((Alumno)alumno).setCarrera(save));

        alumnoRepo.saveAll(personas);

        //when
        String carreraNombre = "Ingenieria en Alimentos";
        List<Persona> expected = (List<Persona>) ((AlumnoRepository) alumnoRepo).buscarAlumnosPorNombreCarrera(carreraNombre);

        //then

        assertThat(expected.isEmpty()).isTrue();
    }

}