package com.example.demo.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.EdificioDTO;
import com.example.demo.DTOresponse.EdificioResponse;
import com.example.demo.Entity.Colegio;
import com.example.demo.Entity.Edificio;
import com.example.demo.Respository.ColegioRepository;
import com.example.demo.Respository.EdificioRepository;
import com.example.demo.Service.EdificioService;

@Service
public class EdificioImpl implements EdificioService {

    @Autowired
    EdificioRepository edificioRepository;

    @Autowired
    ColegioRepository colegioRepository;

    @Override
    public List<Edificio> findAll() {
        return edificioRepository.findAll();    
    }

    @Override
    public Optional<Edificio> findById(Long id) {
        return edificioRepository.findById(id);
    }
    

    @Override
    public Edificio save(EdificioDTO x) {
        Colegio col = colegioRepository.findById(x.getIdColegio()).get();
        Edificio edifico = new Edificio();
        edifico.setColegio(col);
        edifico.setDescripcion(x.getDescripcion());
        edifico.setNombre(x.getNombre());

        
        return edificioRepository.save(edifico);        
    }

    @Override
    public void deleteById(Long id) {
        edificioRepository.deleteById(id);
    }

    @Override
    public boolean existById(Long id) {
        return edificioRepository.existsById(id);
    }


    @Override
    public Edificio Actualizar(Long id, EdificioDTO x) {
        Colegio col = colegioRepository.findById(x.getIdColegio()).get();
        Edificio edifico = this.findById(id).get();
        // actualizamos
        edifico.setColegio(col);
        edifico.setDescripcion(x.getDescripcion());
        edifico.setNombre(x.getNombre());

        edificioRepository.save(edifico);
        return edifico;
    }

    @Override
    public EdificioResponse findByIdTotal(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
