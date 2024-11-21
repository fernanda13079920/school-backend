package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Entity.Permiso;

public interface PermisoService {
    List<Permiso> findAll();

    Optional<Permiso> findById(Long id);

    Permiso save(Permiso dia);

    void deleteById(Long id);
}
