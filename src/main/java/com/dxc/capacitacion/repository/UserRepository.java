package com.dxc.capacitacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dxc.capacitacion.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select u1_0.id,u1_0.name,u1_0.first_last_name,u1_0.second_last_name from tb_user u1_0 where u1_0.name=:nombre", nativeQuery = true)
    User findByName(String nombre);

    @Query(value = "select id, nombre, primerApellido, segundoApellido from User u1_0 where nombre=:nombre", nativeQuery = true)
    User findByName1(String nombre);
}
