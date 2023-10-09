package com.dxc.capacitacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.capacitacion.dto.UserDto;
import com.dxc.capacitacion.service.UserService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/users")
public class UserCtrl {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<UserDto> getIdUser(@RequestParam Integer id) {
        LOGGER.info("buscando usuario con id: {}", id);
        return new ResponseEntity<>(this.userService.findById(id), HttpStatus.OK);
    }

    @GetMapping("name")
    public ResponseEntity<UserDto> getIdUser(@RequestParam String nombre) {
        LOGGER.info("buscando usuario con id: {}", nombre);
        return new ResponseEntity<>(this.userService.findByName(nombre), HttpStatus.OK);
    }

    @GetMapping("list")
    public ResponseEntity<List<UserDto>> getListUser() {
        List<UserDto> listUser = this.userService.findAll();
        return new ResponseEntity<>(listUser, HttpStatus.OK);
    }

    @GetMapping("listByExample")
    public ResponseEntity<List<UserDto>> getListUser(@RequestParam(required = false) String nombre,
            @RequestParam(required = false) String primerApellido,
            @RequestParam(required = false) String segundoApellido) {
        List<UserDto> listUser = this.userService.findByExample(nombre, primerApellido, segundoApellido);
        return new ResponseEntity<>(listUser, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
        userDto.setId(null);
        UserDto userReultDto = this.userService.save(userDto);
        return new ResponseEntity<>(userReultDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<UserDto> update(@RequestBody UserDto userDto) {
        UserDto userReultDto = this.userService.update(userDto);
        return new ResponseEntity<>(userReultDto, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody Integer id) {
        this.userService.delete(id);
        return new ResponseEntity<>("Eliminacion exitosa", HttpStatus.OK);
    }

}
