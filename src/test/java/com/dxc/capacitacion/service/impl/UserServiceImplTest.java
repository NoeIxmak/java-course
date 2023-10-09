package com.dxc.capacitacion.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dxc.capacitacion.dto.UserDto;
import com.dxc.capacitacion.service.UserService;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    void testFindAll() {
        List<UserDto> listUserDto = userService.findAll();
        assertNotEquals(null, listUserDto);
    }

    // @Test
    // void testFindByExample() {

    // }

    // @Test
    // void testFindById() {

    // }

    // @Test
    // void testFindByName() {

    // }

    // @Test
    // void testSave() {

    // }

    // @Test
    // void testUpdate() {

    // }

    // @Test
    // void testDelete() {

    // }
}
