package com.dxc.capacitacion.service;

import java.util.List;

import com.dxc.capacitacion.dto.EstatusDto;

public interface EstatusService {
    List<EstatusDto> findAll();

    EstatusDto findById(Integer id);

    List<EstatusDto> findByExample(String nombre, String descripcion);

    EstatusDto save(EstatusDto estatusDto);

    EstatusDto update(EstatusDto estatusDto);

    void delete(Integer id);
}
