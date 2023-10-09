package com.dxc.capacitacion.repository;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dxc.capacitacion.model.User;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void testFindByName1() {
        User user = userRepository.findByName1("Mario");
        assertNotEquals(null, user);
    }

    // @Test
    // void testFindByName2() {

    // }

    // @Test
    // void testFindByNameOrPrimerApellidoOrSegundoApellido() {

    // }
}
