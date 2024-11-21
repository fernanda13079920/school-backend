package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.DTOresponse.IdiomaResponse;
import com.example.demo.Entity.PersonaIdioma;
import com.example.demo.Serializable.PersonaIdiomaId;


public interface PersonaIdiomaService {
    List<PersonaIdioma> findAll();

    Optional<PersonaIdioma> findById(PersonaIdiomaId id);

    PersonaIdioma save(PersonaIdioma x);

    void deleteById(PersonaIdiomaId id);

    List< IdiomaResponse> obtenerListaIdioma (Integer carnet);

    void deleteAllByCarnet(Integer carnet); 
}
