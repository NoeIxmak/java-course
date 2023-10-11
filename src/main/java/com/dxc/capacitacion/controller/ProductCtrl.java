package com.dxc.capacitacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.capacitacion.dto.ProductDto;
import com.dxc.capacitacion.service.ProductService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/products")
public class ProductCtrl {

    @Autowired
    private ProductService productService;

    // findAll, findByCodigo, findByExample, save, update y delete)
    @GetMapping
    public ResponseEntity<List<ProductDto>> getALl() {
        List<ProductDto> listProduct = this.productService.findAll();
        return new ResponseEntity<>(listProduct, HttpStatus.OK);
    }
    
    @GetMapping("code")
    public ResponseEntity<ProductDto> getByCodigo(@RequestParam(required = false) String codigo) {
    return new ResponseEntity<>(this.productService.findByCodigo(codigo),
    HttpStatus.OK);
    }

    @GetMapping("list")
    public ResponseEntity<List<ProductDto>> getProductsList(@RequestParam(required = false) String codigo,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String descripcion, @RequestParam(required = false) Integer estatus) {
        List<ProductDto> productsList = this.productService.findByExample(codigo, nombre, descripcion, estatus);
        return new ResponseEntity<>(productsList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto) {
        ProductDto productResultDto = this.productService.save(productDto);
        return new ResponseEntity<>(productResultDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProductDto> update(@RequestBody ProductDto productDto) {
        ProductDto productUpdatetDto = this.productService.save(productDto);
        return new ResponseEntity<>(productUpdatetDto, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam String codigo) {
        this.productService.delete(codigo);
        return new ResponseEntity<>(String.valueOf(codigo) + " Eliminado", HttpStatus.OK);
    }

}
