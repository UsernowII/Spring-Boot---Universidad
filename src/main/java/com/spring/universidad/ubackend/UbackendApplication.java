package com.spring.universidad.ubackend;

import com.spring.universidad.ubackend.modelo.Alumno;
import com.spring.universidad.ubackend.modelo.Direccion;
import com.spring.universidad.ubackend.modelo.Persona;
import com.spring.universidad.ubackend.servicios.contratos.AlumnoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class UbackendApplication {

    @Autowired
    private AlumnoDAO servicio;

    public static void main(String[] args) {
        String[] beanDefinitionNames =  SpringApplication.run(UbackendApplication.class, args).getBeanDefinitionNames();// retorna un aarrays de string con los beans
        //Arrays.asList(beanDefinitionNames).forEach(System.out::println);
    }

    @Bean
    public CommandLineRunner runner(){
        return args -> {
            /*Direccion direccion = new Direccion(
                    "calle Falsa", "125", "1658", "", "", "Kennedy");
            Persona alumno = new Alumno(null, "Martin", "Romero","222222222", direccion);

            Persona persona = servicio.save(alumno);
            System.out.println(persona.toString());

            List<Persona> alumnos = (List<Persona>) servicio.findAll();
            alumnos.forEach(System.out::println);
            */


        };
    }

}
