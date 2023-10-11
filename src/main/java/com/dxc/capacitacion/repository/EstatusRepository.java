package com.dxc.capacitacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxc.capacitacion.model.Estatus;

@Repository
public interface EstatusRepository extends JpaRepository<Estatus, Integer> {

}
