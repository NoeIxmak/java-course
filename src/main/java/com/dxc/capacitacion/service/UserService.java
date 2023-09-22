package com.dxc.capacitacion.service;

import java.util.List;

import com.dxc.capacitacion.dto.UserDto;

public class UserService {
    List<UserDto> findAll();
    UserDto save(UserDto userDto);
}
