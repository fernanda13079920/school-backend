package com.example.demo.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Formacion;
import com.example.demo.Respository.FormacionRepository;
import com.example.demo.Service.FormacionService;

@Service
public class FormacionImpl implements FormacionService{

    
    @Autowired
    FormacionRepository r;

    @Override
    public List<Formacion> findAll() {
        return r.findAll();

    }

    @Override
    public Formacion findById(Long id) {
        return  r.findById(id).orElseThrow();

    }

    @Override
    public Formacion save(Formacion formacion) {
        return r.save(formacion);

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
