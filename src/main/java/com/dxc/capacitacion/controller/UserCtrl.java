package com.dxc.capacitacion.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.capacitacion.dto.UserDto;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/users")
@Log4j2
public class UserCtrl {
    @GetMapping
    public ResponseEntity<UserDto> getUser() {
        return new ResponseEntity<>(new UserDto(1l, "mario", "moreno", "blanco"), HttpStatus.OK);
    }

    @GetMapping("list")
    public ResponseEntity<List<UserDto>> getListUser() {
        UserDto user1 = new UserDto(null, null, null, null);
        UserDto user2 = new UserDto(null, null, null, null);
        List<UserDto> listUser = new ArrayList<>();
        listUser.add(user1);
        listUser.add(user2);
        return new ResponseEntity<>(listUser, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
        LOGGER.info("Guardando: " + userDto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<UserDto> update(@RequestBody UserDto userDto) {
        LOGGER.info("Actualizando: " + userDto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody Long id) {
        LOGGER.info("eliminando: " + id);
        return new ResponseEntity<>("Eliminacion exitosa", HttpStatus.OK);
    }

}
