package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.Entity.Aula;

public interface AulaService {
    List<Aula> findAll();

    Optional<Aula> findById(Long id);

    Aula save(Aula x);

    void deleteById(Long id);
    
    boolean existById(Long id);

    boolean existByNombre(String name);
}
