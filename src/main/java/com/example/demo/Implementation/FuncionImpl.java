package com.example.demo.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Funcion;
import com.example.demo.Respository.FuncionRepository;
import com.example.demo.Service.FuncionService;

@Service
public class FuncionImpl implements FuncionService{

    @Autowired
    FuncionRepository r;

    @Override
    public List<Funcion> findAll() {
        return r.findAll();

    }

    @Override
    public Funcion findById(Long id) {
        return  r.findById(id).orElseThrow();

    }

    @Override
    public Funcion save(Funcion funcion) {
        return r.save(funcion);

    }

    @Override
    public void deleteById(Long id) {
        r.deleteById(id);

    }

    @Override
    public boolean existsById(Long id) {
        return r.existsById(id);
    }

}
