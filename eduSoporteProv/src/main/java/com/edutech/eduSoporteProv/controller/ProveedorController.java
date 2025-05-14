package com.edutech.eduSoporteProv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.eduSoporteProv.model.Proveedor;
import com.edutech.eduSoporteProv.service.ProveedorService;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<List<Proveedor>> getProveedores(){
        List<Proveedor> proveedores = proveedorService.findAll();
        if(!proveedores.isEmpty()){
            return new ResponseEntity<>(proveedores, HttpStatus.OK);
        // si proveedores tiene un objeto
        }
        // si no contiene proveedores
        return new ResponseEntity<>(proveedores, HttpStatus.NO_CONTENT);
    }
}
