package com.example.demo.DTO;

public class EspacioDTO {
    private Long id;
    private Long idEdificio;
    private Integer codColegio;
    private String nombre;
    private String descripcion;
    private String ubicacion;

    public EspacioDTO() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getIdEdificio() {
        return idEdificio;
    }
    public void setIdEdificio(Long idEdificio) {
        this.idEdificio = idEdificio;
    }
    public Integer getCodColegio() {
        return codColegio;
    }
    public void setCodColegio(Integer codColegio) {
        this.codColegio = codColegio;
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
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }


}
