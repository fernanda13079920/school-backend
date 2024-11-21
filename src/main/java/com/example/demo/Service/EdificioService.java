package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.DTO.EdificioDTO;
import com.example.demo.DTOresponse.EdificioResponse;
import com.example.demo.Entity.Edificio;

public interface EdificioService {
    List<Edificio> findAll();

    Optional<Edificio> findById(Long id);

    EdificioResponse findByIdTotal(Long id);

    Edificio save(EdificioDTO x);

    void deleteById(Long id);
    
    boolean existById(Long id);

    Edificio Actualizar(Long id, EdificioDTO x);

}
