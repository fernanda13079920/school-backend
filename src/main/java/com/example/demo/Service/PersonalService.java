package com.example.demo.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.DTO.PersonalDTO;
import com.example.demo.Entity.Personal;


public interface PersonalService {
    List<Personal> findAll();

    Personal findById(Integer id);

    Personal save(Personal x);

    void deleteById(Integer id);

    boolean existsById(Integer id);

    ResponseEntity<?> saveTransaccion(PersonalDTO x);
}
