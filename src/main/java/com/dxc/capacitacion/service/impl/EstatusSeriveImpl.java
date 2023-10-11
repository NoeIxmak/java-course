package com.dxc.capacitacion.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.dxc.capacitacion.dto.EstatusDto;
import com.dxc.capacitacion.mapper.EstatusMapper;
import com.dxc.capacitacion.model.Estatus;
import com.dxc.capacitacion.repository.EstatusRepository;
import com.dxc.capacitacion.service.EstatusService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class EstatusSeriveImpl implements EstatusService {

    @Autowired
    EstatusRepository estatusRepository;

    @Override
    public List<EstatusDto> findAll() {
        return EstatusMapper.INSTANCE.toDto(estatusRepository.findAll());
    }

    @Override
    public EstatusDto findById(Integer id) {
        EstatusDto estatusDto = null;
        Optional<Estatus> estatus = estatusRepository.findById(id);

        if (estatus.isPresent()) {
            estatusDto = EstatusMapper.INSTANCE.toDto(estatus.get());
        }

        return estatusDto;
    }

    @Override
    public List<EstatusDto> findByExample(String nombre, String descripcion) {
        Estatus estatus = new Estatus(null, nombre, descripcion);
        List<Estatus> estatusList = estatusRepository.findAll(Example.of(estatus));
        return EstatusMapper.INSTANCE.toDto(estatusList);
    }

    @Override
    public EstatusDto save(EstatusDto estatusDto) {
        Estatus estatusResult = estatusRepository.save(EstatusMapper.INSTANCE.toModel(estatusDto));
        return EstatusMapper.INSTANCE.toDto(estatusResult);
    }

    @Override
    public EstatusDto update(EstatusDto estatusDto) {
        LOGGER.info("Actualizando en capa de servicio: " + estatusDto);
        Estatus estatusResult = estatusRepository.save(EstatusMapper.INSTANCE.toModel(estatusDto));
        return EstatusMapper.INSTANCE.toDto(estatusResult);
    }

    @Override
    public void delete(Integer id) {
        estatusRepository.deleteById(id);
    }

}
