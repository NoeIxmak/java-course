package com.dxc.capacitacion.service;

import java.util.List;

import com.dxc.capacitacion.dto.ProductDto;
import com.dxc.capacitacion.dto.ProductViewDto;

public interface ProductService {
    List<ProductDto> findAll();

    ProductDto findByCodigo(String codigo);

    List<ProductDto> findByExample(String codigo, String nombre, String descripcion, Integer estatus);

    ProductDto save(ProductDto productDto);

    ProductDto update(ProductDto productDto);

    void delete(String codigo);

    List<ProductViewDto> findAllView();
}
