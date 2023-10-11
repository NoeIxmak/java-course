package com.dxc.capacitacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.capacitacion.dto.EstatusDto;
import com.dxc.capacitacion.service.EstatusService;

@RestController
@RequestMapping("/estatus")
public class EstatusCtrl {

    @Autowired
    private EstatusService estatusService;

    @GetMapping
    public ResponseEntity<List<EstatusDto>> getAll() {
        List<EstatusDto> listEstatus = this.estatusService.findAll();
        return new ResponseEntity<>(listEstatus, HttpStatus.OK);
    }

    @GetMapping("id")
    public ResponseEntity<EstatusDto> getEstatusById(@RequestParam Integer id) {
        return new ResponseEntity<>(this.estatusService.findById(id), HttpStatus.OK);
    }

    @GetMapping("list")
    public ResponseEntity<List<EstatusDto>> getEstatusList(@RequestParam(required = false) String nombre,
            @RequestParam(required = false) String descripcion) {
        List<EstatusDto> estatusList = this.estatusService.findByExample(nombre, descripcion);
        return new ResponseEntity<>(estatusList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EstatusDto> save(@RequestBody EstatusDto estatusDto) {
        EstatusDto estatusResultDto = this.estatusService.save(estatusDto);
        return new ResponseEntity<>(estatusResultDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<EstatusDto> update(@RequestBody EstatusDto estatustDto) {
        EstatusDto estatusUpdatetDto = this.estatusService.update(estatustDto);
        return new ResponseEntity<>(estatusUpdatetDto, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam Integer id) {
        this.estatusService.delete(id);
        return new ResponseEntity<>(String.valueOf(id) + " Eliminado", HttpStatus.OK);
    }
}
