package com.example.demo.DTOresponse;

import java.util.List;

import com.example.demo.Entity.Personal;

public class PersonalResponse {
    private Personal personal;
    private rolResponse rol;
    private List<?> idiomas;

    public PersonalResponse() {
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public rolResponse getRol() {
        return rol;
    }

    public void setRol(rolResponse rol) {
        this.rol = rol;
    }

    public List<?> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<?> idiomas) {
        this.idiomas = idiomas;
    }
    
}
