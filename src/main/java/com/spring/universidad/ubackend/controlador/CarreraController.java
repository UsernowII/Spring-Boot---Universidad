package com.spring.universidad.ubackend.controlador;

import com.spring.universidad.ubackend.modelo.entidades.Carrera;
import com.spring.universidad.ubackend.servicios.contratos.CarreraDAO;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Deprecated // Saber que esta clase no tiene continuidad
@RestController
@RequestMapping("/carreras")
@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "false")
public class CarreraController extends GenericController<Carrera, CarreraDAO>{


    public CarreraController(CarreraDAO service) {
        super(service);
        nombreEntidad = "Carrera";
    }


    @PutMapping("/{id}")
    public ResponseEntity<?>actualizarCarrera(@PathVariable Integer id, @RequestBody Carrera carrera){
        Map<String , Object> mensaje = new HashMap<>();
        Carrera carreraUpdate;
        Optional<Carrera> oCarrera = service.finById(id);
        if (!oCarrera.isPresent()){
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("%s con ID %d no existe", nombreEntidad, id));
            return ResponseEntity.badRequest().body(mensaje);
        }
        carreraUpdate = oCarrera.orElseThrow();
        carreraUpdate.setCantidadAnios(carrera.getCantidadAnios());
        carreraUpdate.setCantidadMaterias(carrera.getCantidadMaterias());
        mensaje.put("datos",service.save(carreraUpdate) );
        mensaje.put("success", Boolean.TRUE );
        return ResponseEntity.ok(mensaje);
    }

    @PostMapping()
    public ResponseEntity<?> altaCarrera(@Valid @RequestBody Carrera carrera, BindingResult result){
        Map<String, Object> validaciones = new HashMap<>();
        if (result.hasErrors()) {
            result.getFieldErrors().forEach(error -> validaciones.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(validaciones);
        }
        return ResponseEntity.ok(service.save(carrera));
    }


    // Sin Herencia del generic controller y sin Response

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

     */
}
