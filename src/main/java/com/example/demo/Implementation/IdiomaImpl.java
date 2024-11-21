package com.example.demo.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Idioma;
import com.example.demo.Respository.IdiomaRespository;
import com.example.demo.Service.IdiomaService;

@Service
public class IdiomaImpl implements IdiomaService {

    @Autowired
    IdiomaRespository r;
    @Override
    public List<Idioma> findAll() {
        return r.findAll();
    }

    @Override
    public Idioma findById(Long id) {
        return r.findById(id).orElseThrow();
    }
}
