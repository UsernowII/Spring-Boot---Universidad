package com.spring.universidad.ubackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class UbackendApplication {


    public static void main(String[] args) {
        String[] beanDefinitionNames =  SpringApplication.run(UbackendApplication.class, args).getBeanDefinitionNames();
        //Arrays.asList(beanDefinitionNames).forEach(System.out::println);
    }

}
