package com.dxc.capacitacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dxc.capacitacion.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select p1_0.codigo from tb_producto p1_0 where p1_0.codigo=:codigo", nativeQuery = true)
    Product findByCodigo2(String codigo);

    @Query(value = "select p from Product p where codigo=:codigo")
    Product findByCodigo1(String codigo);
}
