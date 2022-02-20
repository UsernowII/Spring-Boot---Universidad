package com.spring.universidad.ubackend.servicios.implementaciones;

import com.spring.universidad.ubackend.modelo.Persona;
import com.spring.universidad.ubackend.modelo.enumeradores.TipoEmpleado;
import com.spring.universidad.ubackend.repositorios.EmpleadoRepository;
import com.spring.universidad.ubackend.repositorios.PersonaRepository;
import com.spring.universidad.ubackend.servicios.contratos.EmpleadoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class EmpleadoDAOImpl extends PersonaDAOImpl implements EmpleadoDAO {


    @Autowired
    public EmpleadoDAOImpl(@Qualifier("repositorioEmpleados")PersonaRepository repository) {
        super(repository);
    }


    @Override
    public Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado) {
        return ((EmpleadoRepository)repository).findEmpleadoByTipoEmpleado(tipoEmpleado);
    }
}
