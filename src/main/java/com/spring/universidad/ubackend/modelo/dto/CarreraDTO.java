package com.spring.universidad.ubackend.modelo.dto;


import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarreraDTO {

    private Integer codigo;
    @NotNull
    @NotEmpty(message = "Debe ingresar un valor")
    @Size(min = 0, max = 80)
    //@Pattern(regexp = "^[A-Z]")
    private String nombre;
    @Positive(message = "El valor no puede ser negativo")
    private Integer cantidad_materias;
    @Positive
    private Integer cantidad_anios;




}
