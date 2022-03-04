package com.spring.universidad.ubackend.repositorios;

import com.spring.universidad.ubackend.modelo.entidades.Empleado;
import com.spring.universidad.ubackend.modelo.entidades.Persona;
import com.spring.universidad.ubackend.modelo.entidades.Profesor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static com.spring.universidad.ubackend.datos.DatosDummy.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
class PersonaRepositoryTest {

    @Autowired
    @Qualifier("repositorioAlumnos")
    PersonaRepository alumnoRepo;

    @Autowired
    @Qualifier("repositorioEmpleados")
    PersonaRepository empleadoRepo;

    @Autowired
    @Qualifier("profesorRepository")
    PersonaRepository profeRepo;

    @Test
    void buscarPorNombreYApellido() {
        //given
        Persona save = empleadoRepo.save(empleado01());

        //when
        Optional<Persona> expected = empleadoRepo.buscarPorNombreYApellido(
                empleado01().getNombre(), empleado01().getApellido());

        //then
        assertThat(expected.orElseThrow()).isInstanceOf(Empleado.class);
        assertThat(expected.get()).isEqualTo(save);
    }

    @Test
    void buscarPorDni() {
        //given
        Persona save = profeRepo.save(profesor01());

        //when
        Optional<Persona> expected = profeRepo.buscarPorDni(profesor01().getDni());

        //then
        assertThat(expected.orElseThrow()).isInstanceOf(Profesor.class);
        assertThat(expected.get()).isEqualTo(save);
        assertThat(expected.get().getDni()).isEqualTo(save.getDni());

    }

    @Test
    void buscarPersonaPorApellido() {
        //given
        Iterable<Persona> personas = alumnoRepo.saveAll(Arrays.asList
                (alumno01(), alumno02(), alumno03())
        );

        //when
        String apellido = "Benitez";
        List<Persona> expected = (List<Persona>) alumnoRepo.buscarPersonaPorApellido(apellido);

        //then
        assertThat((expected.size()) == 2).isTrue();

    }

}