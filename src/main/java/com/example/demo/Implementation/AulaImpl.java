package com.example.demo.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Aula;
import com.example.demo.Respository.AulaRepository;
import com.example.demo.Service.AulaService;

@Service
public class AulaImpl implements AulaService{

    @Autowired
    AulaRepository r;

    @Override
    public List<Aula> findAll() {
        return r.findAll();
    }

    @Override
    public Optional<Aula> findById(Long id) {
        return r.findById(id);
    }

    @Override
    public Aula save(Aula x) {
        return r.save(x);
    }

    @Override
    public void deleteById(Long id) {
        r.deleteById(id);
    }

    @Override
    public boolean existById(Long id) {
        return r.existsById(id);
    }

    @Override
    public boolean existByNombre(String name) {
       return r.existsByNombre(name);
    }
}
