package com.example.demo.DTO;

public class EdificioDTO {
    private Long idEdificio;
    private String nombre;
    private String descripcion;
    private Integer idColegio;

    public EdificioDTO() {
    }

    public Long getIdEdificio() {
        return idEdificio;
    }

    public void setIdEdificio(Long idEdificio) {
        this.idEdificio = idEdificio;
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

    public Integer getIdColegio() {
        return idColegio;
    }

    public void setIdColegio(Integer idColegio) {
        this.idColegio = idColegio;
    }

}
