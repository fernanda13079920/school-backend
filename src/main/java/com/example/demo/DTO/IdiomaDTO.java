package com.example.demo.DTO;

import com.example.demo.Entity.PersonaIdioma.EstadoEnumB;


public class IdiomaDTO {

    private Long idIdioma;
    private EstadoEnumB estadoEscribe;
    private EstadoEnumB estadoHabla;
    private EstadoEnumB estadoLee;


    public IdiomaDTO() {
    }

    public Long getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Long idIdioma) {
        this.idIdioma = idIdioma;
    }

    public EstadoEnumB getEstadoEscribe() {
        return estadoEscribe;
    }

    public void setEstadoEscribe(EstadoEnumB estadoEscribe) {
        this.estadoEscribe = estadoEscribe;
    }

    public EstadoEnumB getEstadoHabla() {
        return estadoHabla;
    }

    public void setEstadoHabla(EstadoEnumB estadoHabla) {
        this.estadoHabla = estadoHabla;
    }

    public EstadoEnumB getEstadoLee() {
        return estadoLee;
    }

    public void setEstadoLee(EstadoEnumB estadoLee) {
        this.estadoLee = estadoLee;
    }



}
