package com.dxc.capacitacion.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dxc.capacitacion.dto.EstatusDto;
import com.dxc.capacitacion.service.EstatusService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class EstatusSeriveImplTest {

    @Autowired
    EstatusService estatusService;

    @Test
    @Order(4)
    void testFindAll() {
        List<EstatusDto> listEstatusDto = this.estatusService.findAll();
        for (EstatusDto estatusDto : listEstatusDto) {
            LOGGER.info(estatusDto);
        }
        assertNotNull(listEstatusDto);
    }

    @Test
    @Order(5)
    void testFindByExample() {
        List<EstatusDto> listEstatusDto = this.estatusService.findByExample(null, "Orden Recibida");
        for (EstatusDto estatusDto : listEstatusDto) {
            LOGGER.info(estatusDto);
        }
        assertNotNull(listEstatusDto);
    }

    @Test
    @Order(6)
    void testFindById() {
        EstatusDto result = this.estatusService.findById(2);
        EstatusDto result2 = this.estatusService.findById(100);
        assertNotNull(result);
        assertNull(result2);
    }

    @Test
    @Order(1)
    void testSave() {
        EstatusDto estatusNew = new EstatusDto(200, "Test", "Test Desc");
        EstatusDto result = this.estatusService.save(estatusNew);
        assertEquals(result, estatusNew);
    }

    @Test
    @Order(2)
    void testUpdate() {
        EstatusDto estatusNew = new EstatusDto(200, "TestUpdated", "Test Updated Desc");
        EstatusDto result = this.estatusService.update(estatusNew);
        assertEquals(result, estatusNew);
    }

    @Test
    @Order(3)
    void testDelete() {
        this.estatusService.delete(200);
        EstatusDto result = this.estatusService.findById(200);
        assertNull(result);
    }
}
