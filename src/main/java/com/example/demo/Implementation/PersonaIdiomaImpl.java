package com.example.demo.Implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.IdiomaDTO;
import com.example.demo.DTOresponse.IdiomaResponse;
import com.example.demo.Entity.PersonaIdioma;
import com.example.demo.Respository.PersonaIdiomaRepository;
import com.example.demo.Serializable.PersonaIdiomaId;
import com.example.demo.Service.PersonaIdiomaService;

import jakarta.transaction.Transactional;

@Service
public class PersonaIdiomaImpl implements PersonaIdiomaService{

    @Autowired
    PersonaIdiomaRepository r;

    @Override
    public List<PersonaIdioma> findAll() {
        return r.findAll();
    }

    @Override
    public Optional<PersonaIdioma> findById(PersonaIdiomaId id) {
        return r.findById(id);
    }

    @Override
    public PersonaIdioma save(PersonaIdioma x) {
        return r.save(x);
    }

    @Override
    public void deleteById(PersonaIdiomaId id) {
        r.deleteById(id);
    }

    @Override
    public List<IdiomaResponse> obtenerListaIdioma(Integer carnet) {
        List<PersonaIdioma> personaIdiomas = r.findByIdIdPersonal(carnet);

        if (personaIdiomas.isEmpty()) {
            return List.of(); // Devolver una lista vacía si no hay registros
        }
        List<IdiomaResponse> idiomaResponses = personaIdiomas.stream().map(pi -> {
            // Crear IdiomaDTO para los detalles de este idioma en específico
            IdiomaDTO idiomaDTO = new IdiomaDTO();
            idiomaDTO.setIdIdioma(pi.getIdioma().getId());
            idiomaDTO.setEstadoEscribe(pi.getEstadoEscribe());
            idiomaDTO.setEstadoHabla(pi.getEstadoHabla());
            idiomaDTO.setEstadoLee(pi.getEstadoLee());

            // Crear y devolver IdiomaResponse
            IdiomaResponse idiomaResponse = new IdiomaResponse();
            idiomaResponse.setIdIdioma(pi.getIdioma().getId());
            idiomaResponse.setIdioma(pi.getIdioma().getNombre()); // Asumiendo que Idioma tiene un campo nombre
            idiomaResponse.setInfo(List.of(idiomaDTO));

            return idiomaResponse;
        }).collect(Collectors.toList());

        return idiomaResponses;
    }

    @Override
    @Transactional
    public void deleteAllByCarnet(Integer carnet) {
        r.deleteByPersonalCarnet(carnet);
    }

}
