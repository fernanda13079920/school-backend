package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Formacion;

public interface FormacionService {
    List<Formacion> findAll();

    Formacion findById(Long id);

    Formacion save(Formacion formacion);

    void deleteById(Long id);
    boolean existsById(Long id);
}
