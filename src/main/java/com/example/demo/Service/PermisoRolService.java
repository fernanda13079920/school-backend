package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Entity.PermisoRol;


public interface PermisoRolService {
    List<PermisoRol> findAll();

    Optional<PermisoRol> findById(Long id);

    PermisoRol save(PermisoRol dia);

    void deleteById(Long id);


}
