package com.dxc.capacitacion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstatusDto {
    private Integer id;
    private String nombre;
    private String descripcion;
}
