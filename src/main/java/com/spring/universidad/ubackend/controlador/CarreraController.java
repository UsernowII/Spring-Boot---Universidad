package com.spring.universidad.ubackend.controlador;

import com.spring.universidad.ubackend.exception.BadRequestException;
import com.spring.universidad.ubackend.modelo.Carrera;
import com.spring.universidad.ubackend.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carreras")
public class CarreraController extends GenericController<Carrera, CarreraDAO>{


    public CarreraController(CarreraDAO service) {
        super(service);
        nombreEntidad = "Carrera";
    }



    @GetMapping("/{codigo}")
    public Carrera obtenerPorId(@PathVariable( value = "codigo", required = false) Integer id){
        Optional<Carrera> oCarrera = service.finById(id);
        if (!oCarrera.isPresent()){
            throw new BadRequestException(String.format("No existe la carrera con id %d", id) );
        }
        return oCarrera.orElseThrow();
    }

    @PostMapping()
    public Carrera altaCarrera(@RequestBody Carrera carrera){
        if (carrera.getCantidadAnios() <= 0 ){
            throw new BadRequestException("El campo cantidad de años no puede ser negativo");
        }
        if (carrera.getCantidadMaterias() <= 0 ){
            throw new BadRequestException("El campo cantidad de materia no puede ser negativo");
        }
        return service.save(carrera);
    }

    @PutMapping("/{id}")
    public Carrera actualizarCarrera(@PathVariable Integer id, @RequestBody Carrera carrera){
        Carrera carreaUpdate;
        Optional<Carrera> oCarrera = service.finById(id);
        if (!oCarrera.isPresent()){
            throw new BadRequestException(String.format("No existe la carrera con id %d", id) );
        }
        carreaUpdate = oCarrera.orElseThrow();
        carreaUpdate.setCantidadAnios(carrera.getCantidadAnios());
        carreaUpdate.setCantidadMaterias(carrera.getCantidadMaterias());
        return service.save(carreaUpdate);
    }

    @DeleteMapping("/{id}")
    public void eliminarCarrera(@PathVariable Integer id){
        service.deleteById(id);
    }

    // Sin Herencia del generic controller

    //private final CarreraDAO carreraDAO;

    /*@Autowired
    public CarreraController(CarreraDAO carreraDAO) {
        this.carreraDAO = carreraDAO;
    }


    @GetMapping()
    public List<Carrera> obtenerTodos(){
        List<Carrera> carreras = (List<Carrera>) carreraDAO.findAll();
        if (carreras.isEmpty()){
            throw new BadRequestException("No existen carreras");
        }
        return carreras;
    }

     */
}
