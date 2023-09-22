package com.dxc.capacitacion.service;

import java.util.List;

import com.dxc.capacitacion.dto.UserDto;

public interface UserService {
    List<UserDto> findAll();

    UserDto save(UserDto userDto);

    UserDto update(UserDto userDto);

    void delete(Integer id);
}
