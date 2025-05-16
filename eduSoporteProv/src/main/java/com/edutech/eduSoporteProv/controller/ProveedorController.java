package com.edutech.eduSoporteProv.controller;

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

    @PostMapping
    public ResponseEntity<Proveedor> postProveedor(@RequestBody Proveedor proveedor){
        Proveedor buscado = proveedorService.findxId(proveedor.getId());
        if (buscado == null){
            return new ResponseEntity<>(proveedorService.save(proveedor), HttpStatus.ACCEPTED);
        }   else{
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @DeleteMapping  
    public ResponseEntity<Proveedor> deleteProveedor(@RequestBody Proveedor proveedor){
        Proveedor borrar = proveedorService.deletexId(proveedor.getId());
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }
}
