package com.example.demo.Serializable;

import jakarta.persistence.Embeddable;


@Embeddable
public class PersonaIdiomaId {
    private Integer idPersonal;
    private Long idIdioma;

    public PersonaIdiomaId() {
    }

    public Integer getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Integer idPersonal) {
        this.idPersonal = idPersonal;
    }

    public Long getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Long idIdioma) {
        this.idIdioma = idIdioma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonaIdiomaId that = (PersonaIdiomaId) o;

        if (!idPersonal.equals(that.idPersonal)) return false;
        return idIdioma.equals(that.idIdioma);
    }

    @Override
    public int hashCode() {
        int result = idPersonal.hashCode();
        result = 31 * result + idIdioma.hashCode();
        return result;
    }
}
