package com.dxc.capacitacion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private String codigo;
    private String nombre;
    private String descripcion;
    private Integer estatus;
}
