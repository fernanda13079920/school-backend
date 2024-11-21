package com.example.demo.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.EspacioDTO;
import com.example.demo.Entity.Colegio;
import com.example.demo.Entity.Edificio;
import com.example.demo.Entity.Espacio;
import com.example.demo.Respository.EspacioRepository;
import com.example.demo.Service.ColegioService;
import com.example.demo.Service.EdificioService;
import com.example.demo.Service.EspacioService;

@Service
public class EspacioImpl implements EspacioService{

    @Autowired
    EspacioRepository service;

    @Autowired
    ColegioService colegioS;

    @Autowired
    EdificioService edificioS;

    @Override
    public List<Espacio> findAll() {
        return service.findAll();
    }

    @Override
    public Optional<Espacio> findById(Long id) {
        return service.findById(id);
    }

    @Override
    public Espacio save(EspacioDTO x) {
        Edificio edificio = edificioS.findById(x.getIdEdificio()).get();
        Espacio nuevo = new Espacio();

        nuevo.setNombre(x.getNombre());
        nuevo.setDescripcion(x.getDescripcion());
        nuevo.setUbicacion(x.getUbicacion());
        nuevo.setEdificio(edificio);

        if (x.getCodColegio() != null) {
            Colegio colegio = colegioS.findById(x.getCodColegio());
            nuevo.setColegio(colegio);
        } else {
            nuevo.setColegio(null);
        }
        Espacio espacio = service.save(nuevo);

        return espacio;
    }

    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }

    @Override
    public boolean existById(Long id) {
        return service.existsById(id);
    }

    @Override
    public Espacio Actualizar(Long id, EspacioDTO x) {
        Edificio edificio = edificioS.findById(x.getIdEdificio()).get();
        Espacio espacio = this.findById(id).get();
       
        espacio.setNombre(x.getNombre());
        espacio.setDescripcion(x.getDescripcion());
        espacio.setUbicacion(x.getUbicacion());
        espacio.setEdificio(edificio);

        if (x.getCodColegio() != null) {
            Colegio colegio = colegioS.findById(x.getCodColegio());
            espacio.setColegio(colegio);
        } else {
            espacio.setColegio(null);
        }
        Espacio espacioAct = service.save(espacio);

        return espacioAct;
    }
    


}
