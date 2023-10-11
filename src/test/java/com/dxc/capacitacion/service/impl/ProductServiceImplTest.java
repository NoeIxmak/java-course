package com.dxc.capacitacion.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dxc.capacitacion.dto.EstatusDto;
import com.dxc.capacitacion.dto.ProductDto;
import com.dxc.capacitacion.dto.ProductViewDto;
import com.dxc.capacitacion.model.Product;
import com.dxc.capacitacion.repository.ProductRepository;
import com.dxc.capacitacion.service.EstatusService;
import com.dxc.capacitacion.service.ProductService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private EstatusService estatusService;

    @Test
    void findAllView() {
        List<ProductViewDto> listProductDto = productService.findAllView();
        for (ProductViewDto productDto : listProductDto) {
            LOGGER.info(productDto);
        }
        assertNotNull(listProductDto);
    }

    @Test
    void testFindAll() {
        List<ProductDto> listProductDto = productService.findAll();
        for (ProductDto productDto : listProductDto) {
            LOGGER.info(productDto);
        }
        assertNotNull(listProductDto);
    }

    @Test
    void testFindByExample() {
        List<ProductDto> listProductDto = this.productService.findByExample(null, "Escritorio", null, null);
        for (ProductDto productDto : listProductDto) {
            LOGGER.info(productDto);
        }
        assertNotNull(listProductDto);
    }

    @Test
    @Order(1)
    void testSave() {
        EstatusDto estatusDto = new EstatusDto(50, "Usado", "Ligeras marcas de uso");
        this.estatusService.save(estatusDto);
        ProductDto productDto = new ProductDto("P900", "Pantalla", "Pantalla descripcion", 1, estatusDto);

        ProductDto result = productService.save(productDto);
        assertNotNull(result);
        this.estatusService.delete(50);
    }

    @Test
    @Order(2)
    void testUpdate() {
        ProductDto productDto = new ProductDto("P900", "Pantalla Updated", "Pantalla descripcion Updated", 1, null);
        ProductDto result = this.productService.update(productDto);
        assertEquals(productDto, result);
    }

    @Test
    @Order(3)
    void testDelete() {
        this.productService.delete("P900");
        Product result = this.productRepository.findByCodigo1("P900");
        assertNull(result);
    }
}
