package com.example.demo.DTOresponse;

import java.util.List;

import com.example.demo.Entity.Colegio;

public class EdificioResponse {

    private Long id;
    private String nombre;
    private String descripcion;
    private Colegio colegio;
    private List<String> aulas;

    public EdificioResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Colegio getColegio() {
        return colegio;
    }

    public void setColegio(Colegio colegio) {
        this.colegio = colegio;
    }

    public List<String> getAulas() {
        return aulas;
    }

    public void setAulas(List<String> aulas) {
        this.aulas = aulas;
    }
}
