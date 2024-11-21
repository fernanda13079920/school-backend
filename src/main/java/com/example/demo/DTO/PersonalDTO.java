package com.example.demo.DTO;

import java.util.Date;
import java.util.List;

import com.example.demo.Entity.Personal.GeneroEnum;



public class PersonalDTO {
    private Integer carnet;
    private Integer codigoColegio;
    private Long idFinanciamiento;
    private Long idFuncion;
    private Long idFormacion;
    private Long idRol;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private Boolean braile;
    private String complemento;
    private String correo;
    private String denominativo;
    private String direccionDomiciliaria;
    private Boolean extranjero;
    private Date fechaNacimiento;
    private GeneroEnum genero;
    private String nombres;
    private Boolean normalista;
    private Integer nroCelular;
    private Integer nroItem;
    private Integer rda;
    private List<IdiomaDTO> idiomas;


    public PersonalDTO() {
    }

    public Integer getCarnet() {
        return carnet;
    }

    public void setCarnet(Integer carnet) {
        this.carnet = carnet;
    }

    public Integer getCodigoColegio() {
        return codigoColegio;
    }

    public void setCodigoColegio(Integer codigoColegio) {
        this.codigoColegio = codigoColegio;
    }

    public Long getIdFinanciamiento() {
        return idFinanciamiento;
    }

    public void setIdFinanciamiento(Long idFinanciamiento) {
        this.idFinanciamiento = idFinanciamiento;
    }

    public Long getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(Long idFuncion) {
        this.idFuncion = idFuncion;
    }

    public Long getIdFormacion() {
        return idFormacion;
    }

    public void setIdFormacion(Long idFormacion) {
        this.idFormacion = idFormacion;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public Boolean getBraile() {
        return braile;
    }

    public void setBraile(Boolean braile) {
        this.braile = braile;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDenominativo() {
        return denominativo;
    }

    public void setDenominativo(String denominativo) {
        this.denominativo = denominativo;
    }

    public String getDireccionDomiciliaria() {
        return direccionDomiciliaria;
    }

    public void setDireccionDomiciliaria(String direccionDomiciliaria) {
        this.direccionDomiciliaria = direccionDomiciliaria;
    }

    public Boolean getExtranjero() {
        return extranjero;
    }

    public void setExtranjero(Boolean extranjero) {
        this.extranjero = extranjero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnum genero) {
        this.genero = genero;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Boolean getNormalista() {
        return normalista;
    }

    public void setNormalista(Boolean normalista) {
        this.normalista = normalista;
    }

    public Integer getNroCelular() {
        return nroCelular;
    }

    public void setNroCelular(Integer nroCelular) {
        this.nroCelular = nroCelular;
    }

    public Integer getNroItem() {
        return nroItem;
    }

    public void setNroItem(Integer nroItem) {
        this.nroItem = nroItem;
    }

    public Integer getRda() {
        return rda;
    }

    public void setRda(Integer rda) {
        this.rda = rda;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public List<IdiomaDTO> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<IdiomaDTO> idiomas) {
        this.idiomas = idiomas;
    }
    
}
