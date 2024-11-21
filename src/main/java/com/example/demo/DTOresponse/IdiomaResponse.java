package com.example.demo.DTOresponse;
import java.util.List;

import com.example.demo.DTO.IdiomaDTO;


public class IdiomaResponse {

    private Long idIdioma;
    private String idioma;
    private List<IdiomaDTO> info;

    public IdiomaResponse() {
    }

    public Long getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Long idIdioma) {
        this.idIdioma = idIdioma;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public List<IdiomaDTO> getInfo() {
        return info;
    }

    public void setInfo(List<IdiomaDTO> info) {
        this.info = info;
    }
}
