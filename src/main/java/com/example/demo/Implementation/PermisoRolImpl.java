package com.example.demo.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.PermisoRol;
import com.example.demo.Respository.PermisoRolRepository;
import com.example.demo.Service.PermisoRolService;

@Service
public class PermisoRolImpl implements PermisoRolService{

    @Autowired
    PermisoRolRepository r;


    @Override
    public List<PermisoRol> findAll() {
        return r.findAll();
    }

    

    @Override
    public PermisoRol save(PermisoRol dia) {
        return r.save(dia);
    }

    @Override
    public void deleteById(Long id) {
        r.deleteById(id);
    }

    public List<PermisoRol> findByRolId(Long id) {
       return r.findByRolId(id);
    }

    @Override
    public java.util.Optional<PermisoRol> findById(Long id) {
        return r.findById(id);
    }

    

}
