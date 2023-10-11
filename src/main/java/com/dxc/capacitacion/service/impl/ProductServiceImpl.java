package com.dxc.capacitacion.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.dxc.capacitacion.dto.ProductDto;
import com.dxc.capacitacion.dto.ProductViewDto;
import com.dxc.capacitacion.mapper.ProductMapper;
import com.dxc.capacitacion.model.Product;
import com.dxc.capacitacion.repository.ProductRepository;
import com.dxc.capacitacion.service.ProductService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductDto> findAll() {
        return ProductMapper.INSTANCE.toDto(productRepository.findAll());
    }

    @Override
    public List<ProductViewDto> findAllView() {
        return ProductMapper.INSTANCE.toViewDto(this.productRepository.findAll());
    }

    @Override
    public ProductDto findByCodigo(String codigo) {
        Product product = productRepository.findByCodigo1(codigo);

        return ProductMapper.INSTANCE.toDto(product);
    }

    @Override
    public List<ProductDto> findByExample(String codigo, String nombre, String descripcion, Integer estatus) {
        Product product = new Product(codigo, nombre, descripcion, estatus, null);
        List<Product> productList = productRepository.findAll(Example.of(product));
        return ProductMapper.INSTANCE.toDto(productList);
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product productResult = productRepository.save(ProductMapper.INSTANCE.toModel(productDto));
        return ProductMapper.INSTANCE.toDto(productResult);
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        LOGGER.info("Actualizando en capa de servicio: " + productDto);
        Product productResult = productRepository.save(ProductMapper.INSTANCE.toModel(productDto));
        return ProductMapper.INSTANCE.toDto(productResult);
    }

    @Override
    public void delete(String codigo) {
        Product product = productRepository.findByCodigo1(codigo);
        productRepository.delete(product);
    }
}
