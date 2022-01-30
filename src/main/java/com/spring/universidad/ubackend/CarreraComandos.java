package com.spring.universidad.ubackend;

import com.spring.universidad.ubackend.modelo.Carrera;
import com.spring.universidad.ubackend.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CarreraComandos implements CommandLineRunner {

    @Autowired
    private CarreraDAO servicio;

    @Override
    public void run(String... args) throws Exception {
        /*Carrera ingSistemas = new Carrera(null,"Ingeniera en Sistemas", 50, 5 );
        Carrera carrera =  servicio.save(ingSistemas);
        System.out.println(carrera.toString());

         */


        Optional<Carrera> oCarrera = servicio.finById(1);
        if (oCarrera.isPresent()){
            Carrera carrera = oCarrera.get();
            System.out.println(carrera.toString());
        }else {
            System.out.println("Carrera no encontrada");
        }
    }
}
