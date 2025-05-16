package com.edutech.eduSoporteProv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.eduSoporteProv.model.Proveedor;
import com.edutech.eduSoporteProv.repository.ProveedorRepository;

@Service
public class ProveedorService{
    @Autowired
    private ProveedorRepository proveedorRepository;

    public Proveedor save(Proveedor proveedor){ // metodo para agregar proveedores, faltaba agregar eñ package de service
        return proveedorRepository.save(proveedor);
    }

    public List<Proveedor> findAll(){
        return proveedorRepository.findAll();
    }

    public Proveedor findxId(int id){
        return proveedorRepository.findById(id);
    }

    public Proveedor deletexId(int id){
        return proveedorRepository.deleteById(id);
    }

}