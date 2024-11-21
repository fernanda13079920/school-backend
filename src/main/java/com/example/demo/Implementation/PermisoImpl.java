package com.example.demo.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Permiso;
import com.example.demo.Respository.PermisoRepository;
import com.example.demo.Service.PermisoService;


@Service
public class PermisoImpl implements PermisoService{

    @Autowired
    PermisoRepository r;

    @Override
    public List<Permiso> findAll() {
        return r.findAll();
    }

    @Override
    public Optional<Permiso> findById(Long id) {
        return r.findById(id);
    }

    @Override
    public Permiso save(Permiso dia) {
        return r.save(dia);
    }

    @Override
    public void deleteById(Long id) {
        r.deleteById(id);
    }

}
