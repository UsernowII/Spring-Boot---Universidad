package com.spring.universidad.ubackend.repositorios;

import com.spring.universidad.ubackend.datos.DatosDummy;
import com.spring.universidad.ubackend.modelo.entidades.Carrera;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
class CarreraRepositoryTest {

    @Autowired
    CarreraRepository carreraRepository;

    @BeforeEach
    void setUp() {
        //given
        carreraRepository.save(DatosDummy.carrera01(false));
        carreraRepository.save(DatosDummy.carrera02());
        carreraRepository.save(DatosDummy.carrera03(false));
    }


    @AfterEach
    void tearDown() {
        carreraRepository.deleteAll();
    }

    @Test
    @DisplayName("Buscar Carreras por nombre")
    void findCarrerasByNombreContains() {

        //when
        Iterable<Carrera> expected = carreraRepository.findCarrerasByNombreContains("sistemas");

        //then
        assertThat(((List<Carrera>)expected).size() == 2).isTrue();

    }

    @Test
    @DisplayName("Buscar Carreras por nombre No Case Sensitive")
    void findCarrerasByNombreContainsIgnoreCase() {
        //when
        List<Carrera> expected = (List<Carrera>) carreraRepository.findCarrerasByNombreContainsIgnoreCase("sistemas");

        //then
        assertThat(expected.size() == 2).isTrue();
    }

    @Test
    @DisplayName("Buscar Carreras mayor a N años")
    void findCarrerasByCantidadAniosAfter() {
        //when
        List<Carrera> expected = (List<Carrera>) carreraRepository.findCarrerasByCantidadAniosAfter(4);

        //then
        assertThat(expected.size() == 2).isTrue();
    }

}