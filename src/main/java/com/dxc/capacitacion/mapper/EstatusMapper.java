package com.dxc.capacitacion.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.dxc.capacitacion.dto.EstatusDto;
import com.dxc.capacitacion.model.Estatus;

@Mapper
public interface EstatusMapper {
    EstatusMapper INSTANCE = Mappers.getMapper(EstatusMapper.class);

    Estatus toModel(EstatusDto source);

    EstatusDto toDto(Estatus source);

    List<EstatusDto> toDto(List<Estatus> source);
}
