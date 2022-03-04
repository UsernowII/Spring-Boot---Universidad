package com.spring.universidad.ubackend.servicios.implementaciones;

import com.spring.universidad.ubackend.datos.DatosDummy;
import com.spring.universidad.ubackend.modelo.entidades.Carrera;
import com.spring.universidad.ubackend.repositorios.CarreraRepository;
import com.spring.universidad.ubackend.servicios.contratos.CarreraDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class CarreraDAOImplTest {


    CarreraDAO carreraDAO;
    CarreraRepository carreraRepo;

    @BeforeEach
    void setUp() {
        carreraRepo = mock(CarreraRepository.class);
        carreraDAO = new CarreraDAOImpl(carreraRepo);

    }

    @Test
    void findCarrerasByNombreContains() {
        //Given
        String nombre = "Ingenieria";

        when(carreraRepo.findCarrerasByNombreContains(nombre))
                .thenReturn(Arrays.asList(DatosDummy.carrera01(true), DatosDummy.carrera03(true)));

        //when
        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByNombreContains(nombre);

        //then
        assertThat(expected.get(0)).isEqualTo(DatosDummy.carrera01(true));
        assertThat(expected.get(1)).isEqualTo(DatosDummy.carrera03(true));

        verify(carreraRepo).findCarrerasByNombreContains(nombre);
    }

    @Test
    void findCarrerasByNombreContainsIgnoreCase() {
        //Given
        String nombre = "ingenieria";

        when(carreraRepo.findCarrerasByNombreContainsIgnoreCase(nombre))
                .thenReturn(Arrays.asList(DatosDummy.carrera01(true), DatosDummy.carrera03(true)));

        //when
        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByNombreContainsIgnoreCase(nombre);

        //then
        assertThat(expected.get(0)).isEqualTo(DatosDummy.carrera01(true));
        assertThat(expected.get(1)).isEqualTo(DatosDummy.carrera03(true));

        verify(carreraRepo).findCarrerasByNombreContainsIgnoreCase(nombre);
    }

    @Test
    void findCarrerasByCantidadAniosAfter() {
        //Given
        int cantidad = 4;

        when(carreraRepo.findCarrerasByCantidadAniosAfter(cantidad))
                .thenReturn(Arrays.asList(DatosDummy.carrera01(true), DatosDummy.carrera03(true)));

        //when
        List<Carrera> expected = (List<Carrera>) carreraDAO.findCarrerasByCantidadAniosAfter(cantidad);

        //then
        assertThat(expected.get(0)).isEqualTo(DatosDummy.carrera01(true));
        assertThat(expected.get(1)).isEqualTo(DatosDummy.carrera03(true));

        verify(carreraRepo).findCarrerasByCantidadAniosAfter(cantidad);
    }

}