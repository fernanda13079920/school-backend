package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Financiamiento;

public interface FinanciamientoService {
    List<Financiamiento> findAll();

    Financiamiento findById(Long id);

    Financiamiento save(Financiamiento financiamiento);

    void deleteById(Long id);
    boolean existsById(Long id);
}
