package com.dxc.capacitacion.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.capacitacion.dto.UserDto;
import com.dxc.capacitacion.model.User;
import com.dxc.capacitacion.repository.UserRepository;
import com.dxc.capacitacion.service.UserService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDto> findAll() {

        List<UserDto> listUserDto = new ArrayList<>();
        List<User> listModel = userRepository.findAll();

        for (User user : listModel) {
            LOGGER.info("-->" + user);

            listUserDto.add(
                    new UserDto(user.getId(), user.getNombre(), user.getPrimerApellido(), user.getSegundoApellido()));
        }

        return listUserDto;
    }

    @Override
    public UserDto findById(Integer id) {
        UserDto userDto = null;
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userDto = new UserDto(user.get().getId(), user.get().getNombre(), user.get().getPrimerApellido(),
                    user.get().getSegundoApellido());
        }
        return userDto;
    }

    public UserDto findByName(String nombre) {
        UserDto userDto = null;
        User user = userRepository.findByName2(nombre);
        if (user != null) {
            LOGGER.info(user);
            userDto = new UserDto(user.getId(), user.getNombre(), user.getPrimerApellido(),
                    user.getSegundoApellido());
        }

        return userDto;
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
