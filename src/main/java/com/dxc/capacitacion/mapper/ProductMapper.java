package com.dxc.capacitacion.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.dxc.capacitacion.dto.ProductDto;
import com.dxc.capacitacion.model.Product;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toModel(ProductDto source);

    ProductDto toDto(Product source);

    List<ProductDto> toDto(List<Product> source);
}
