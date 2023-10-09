package com.dxc.capacitacion.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.dxc.capacitacion.dto.UserDto;
import com.dxc.capacitacion.mapper.UserMapper;
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
        LOGGER.info("Ejecutando el mapper");
        return UserMapper.INSTANCE.toDto(userRepository.findAll());
    }

    @Override
    public UserDto findById(Integer id) {
        UserDto userDto = null;
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userDto = UserMapper.INSTANCE.toDto(user.get());
        }
        return userDto;
    }

    @Override
    public UserDto findByName(String nombre) {
        User user = userRepository.findByName2(nombre);

        return UserMapper.INSTANCE.toDto(user);
    }

    @Override
    public List<UserDto> findByExample(String nombre, String primerApellido, String segundoApellido) {
        User user1 = new User(null, nombre, primerApellido, segundoApellido);
        List<User> listUser = userRepository.findAll(Example.of(user1));
        return UserMapper.INSTANCE.toDto(listUser);
    }

    @Override
    public UserDto save(UserDto userDto) {
        LOGGER.info("Guardando en capa de servicio: " + userDto);
        User userResult = userRepository.save(UserMapper.INSTANCE.toModel(userDto));
        return UserMapper.INSTANCE.toDto(userResult);
    }

    @Override
    public UserDto update(UserDto userDto) {
        LOGGER.info("Actualizando en capa de servicio: " + userDto);
        User userResult = userRepository.save(UserMapper.INSTANCE.toModel(userDto));
        return UserMapper.INSTANCE.toDto(userResult);
    }

    @Override
    public void delete(Integer id) {
        LOGGER.info("Eliminando en capa de servicio: " + id);
        userRepository.deleteById(id);
    }
}
