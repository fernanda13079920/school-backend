package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.DTO.EspacioDTO;
import com.example.demo.Entity.Espacio;


public interface EspacioService {
    List<Espacio> findAll();

    Optional<Espacio> findById(Long id);

    Espacio save(EspacioDTO x);

    void deleteById(Long id);
    
    boolean existById(Long id);

    Espacio Actualizar(Long id, EspacioDTO x);
}
