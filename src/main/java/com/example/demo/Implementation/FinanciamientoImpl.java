package com.example.demo.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Financiamiento;
import com.example.demo.Respository.FinanciamientoRepository;
import com.example.demo.Service.FinanciamientoService;

@Service
public class FinanciamientoImpl implements FinanciamientoService{
    
    @Autowired
    FinanciamientoRepository r;

    @Override
    public List<Financiamiento> findAll() {
        return r.findAll();
    }

    @Override
    public Financiamiento findById(Long id) {
        return  r.findById(id).orElseThrow();
    }

    @Override
    public Financiamiento save(Financiamiento financiamiento) {
        return r.save(financiamiento);
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
