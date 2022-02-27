package com.spring.universidad.ubackend.servicios.implementaciones;

import com.spring.universidad.ubackend.repositorios.AlumnoRepository;
import com.spring.universidad.ubackend.servicios.contratos.PersonaDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PersonaDAOImplTest {


    PersonaDAO personaDAO;
    @Mock
    AlumnoRepository alumnoRepo;

    @BeforeEach
    void setUp() {
        personaDAO = new PersonaDAOImpl(alumnoRepo);
    }

    @Test
    void buscarPorNombreYApellido() {
        //when

        personaDAO.buscarPorNombreYApellido(anyString(), anyString());

        //then
        verify(alumnoRepo).buscarPorNombreYApellido(anyString(), anyString());

    }

    @Test
    void buscarPorDni() {
        //when

        personaDAO.buscarPorDni(anyString());
        //then
        verify(alumnoRepo).buscarPorDni(anyString());
    }

    @Test
    void buscarPersonaPorApellido() {
        //when

        personaDAO.buscarPersonaPorApellido(anyString());
        //then
        verify(alumnoRepo).buscarPersonaPorApellido(anyString());
    }

}