package com.example.demo.DTO;

import java.util.List;

public class RolDTO {
    private String nombre;
    private String descripcion;
    List<Long> idPermisos;

    public RolDTO() {
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

    public List<Long> getIdPermisos() {
        return idPermisos;
    }

    public void setIdPermisos(List<Long> idPermisos) {
        this.idPermisos = idPermisos;
    }
}
