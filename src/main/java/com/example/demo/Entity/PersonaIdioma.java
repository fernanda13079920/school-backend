package com.example.demo.Entity;

import com.example.demo.Serializable.PersonaIdiomaId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "persona_idioma")
public class PersonaIdioma {

    @EmbeddedId
    private PersonaIdiomaId id;

    @ManyToOne
    @MapsId("idPersonal")
    @JoinColumn(name = "id_personal")
    private Personal personal;

    @ManyToOne
    @MapsId("idIdioma")
    @JoinColumn(name = "id_idioma")
    private Idioma idioma;

    @Enumerated(EnumType.STRING)
    private EstadoEnumB estadoEscribe;

    @Enumerated(EnumType.STRING)
    private EstadoEnumB estadoHabla;

    @Enumerated(EnumType.STRING)
    private EstadoEnumB estadoLee;

    public PersonaIdioma() {
    }

    public PersonaIdiomaId getId() {
        return id;
    }

    public void setId(PersonaIdiomaId id) {
        this.id = id;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
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

    
    public enum EstadoEnumB {
        Muy_Bien,
        Bien,
        Mal,
        No
    }
}
