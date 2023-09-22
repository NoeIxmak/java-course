package com.dxc.capacitacion.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dxc.capacitacion.dto.UserDto;
import com.dxc.capacitacion.service.UserService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserServiceImpl implements UserService {

    @Override
    public List<UserDto> findAll() {
        UserDto user1 = new UserDto(1l, "Pedro", "Hernández", "Santos");
        UserDto user2 = new UserDto(2l, "Carlos", "Lopez", "Barrios");
        UserDto user3 = new UserDto(3l, "Ricardo", "Sanchez", "Noroña");
        List<UserDto> listUser = new ArrayList<>();
        listUser.add(user1);
        listUser.add(user2);
        listUser.add(user3);
        return listUser;
    }

    @Override
    public UserDto save(UserDto userDto) {
        LOGGER.info("Guardando en capa de servicio: " + userDto);
        return userDto;
    }

    @Override
    public UserDto update(UserDto userDto) {
        LOGGER.info("Actualizando en capa de servicio: " + userDto);
        return userDto;
    }

    @Override
    public void delete(Integer id) {
        LOGGER.info("Eliminando en capa de servicio: " + id);

    }
}
