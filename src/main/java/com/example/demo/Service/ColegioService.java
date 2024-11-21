package com.example.demo.Service;
import java.util.List;

import com.example.demo.Entity.Colegio;

public interface ColegioService {

    List<Colegio> findAll();

    Colegio findById(Integer id);

    Colegio save(Colegio colegio);

    void deleteById(Integer id);

    boolean existsById(Integer id);
}
