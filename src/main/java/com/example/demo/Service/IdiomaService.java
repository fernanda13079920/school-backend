package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Idioma;

public interface IdiomaService {
    List<Idioma> findAll();

    Idioma findById(Long id);
}
