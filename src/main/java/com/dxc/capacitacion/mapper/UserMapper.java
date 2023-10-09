package com.dxc.capacitacion.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.dxc.capacitacion.dto.UserDto;
import com.dxc.capacitacion.model.User;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "name", source = "source.nombre")
    User toModel(UserDto source);

    @Mapping(target = "nombre", source = "source.name")
    UserDto toDto(User source);

    List<UserDto> toDto(List<User> source);
}
