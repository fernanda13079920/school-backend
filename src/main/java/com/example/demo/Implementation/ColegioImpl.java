package com.example.demo.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Colegio;
import com.example.demo.Respository.ColegioRepository;
import com.example.demo.Service.ColegioService;



@Service
public class ColegioImpl implements ColegioService {

    @Autowired
    ColegioRepository r;

    @Override
    public List<Colegio> findAll() {
        return r.findAll();
    }

    @Override
    public Colegio findById(Integer id) {
        return r.findById(id).orElseThrow();
    }

    @Override
    public Colegio save(Colegio colegio) {
        return r.save(colegio);
    }

    @Override
    public void deleteById(Integer id) {
        r.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return r.existsById(id);
    }

}
