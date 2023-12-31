package com.dxc.capacitacion.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dxc.capacitacion.model.User;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void testFindByName1() {
        User user = userRepository.findByName2("Alejandra");
        assertNotNull(user);
    }
}
