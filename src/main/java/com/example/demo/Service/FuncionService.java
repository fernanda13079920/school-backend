package com.example.demo.Service;
import java.util.List;

import com.example.demo.Entity.Funcion;
public interface FuncionService {

    List<Funcion> findAll();

    Funcion findById(Long id);

    Funcion save(Funcion funcion);

    void deleteById(Long id);
    boolean existsById(Long id);

}
