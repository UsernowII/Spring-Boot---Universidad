package com.spring.universidad.ubackend.servicios.implementaciones;

import com.spring.universidad.ubackend.repositorios.AlumnoRepository;
import com.spring.universidad.ubackend.servicios.contratos.AlumnoDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;


@SpringBootTest
class AlumnoDAOImplTest {

    @MockBean
    AlumnoRepository alumnoRepo;

    @Autowired
    AlumnoDAO alumnoDAO;

    @Test
    void buscarAlumnosPorNombreCarrera() {
        //when
        alumnoDAO.buscarAlumnosPorNombreCarrera(anyString());

        //then
        verify(alumnoRepo).buscarAlumnosPorNombreCarrera(anyString());

    }

}