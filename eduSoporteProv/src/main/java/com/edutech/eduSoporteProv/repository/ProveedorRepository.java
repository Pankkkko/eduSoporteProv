package com.edutech.eduSoporteProv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutech.eduSoporteProv.model.Proveedor;

public interface ProveedorRepository extends JpaRepository <Proveedor, Integer> {
    
    @SuppressWarnings("uncheked")
    Proveedor save(Proveedor proveedor);
    
    List<Proveedor> findAll();

    Proveedor findById(int id);

    Proveedor deleteById(int id);


}
