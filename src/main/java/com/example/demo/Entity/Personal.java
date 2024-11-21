package com.example.demo.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "personal")
public class Personal {

    @Id
    private Integer carnet;

    @ManyToOne
    @JoinColumn(name = "codigo_colegio", referencedColumnName = "codigo")
    private Colegio colegio;  

    @ManyToOne
    @JoinColumn(name = "id_financiamiento", referencedColumnName = "id")
    private Financiamiento financiamiento;  

    @ManyToOne
    @JoinColumn(name = "id_funcion", referencedColumnName = "id")
    private Funcion funcion;  

    @ManyToOne
    @JoinColumn(name = "id_formacion", referencedColumnName = "id")
    private Formacion formacion;  
    private String apellidoMaterno;
    private String apellidoPaterno;
    private Boolean braile = false;
    private String complemento;
    private String correo;
    private String denominativo;
    private String direccionDomiciliaria;
    private Boolean extranjero = false;
    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Enumerated(EnumType.STRING)
    private GeneroEnum genero;
    private String nombres;
    private Boolean normalista = false;
    private Integer nroCelular;
    private Integer nroItem;
    private Integer rda;

    public Personal() {
    }

    public Integer getCarnet() {
        return carnet;
    }

    public void setCarnet(Integer carnet) {
        this.carnet = carnet;
    }

    public Colegio getColegio() {
        return colegio;
    }

    public void setColegio(Colegio colegio) {
        this.colegio = colegio;
    }

    public Financiamiento getFinanciamiento() {
        return financiamiento;
    }

    public void setFinanciamiento(Financiamiento financiamiento) {
        this.financiamiento = financiamiento;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public Formacion getFormacion() {
        return formacion;
    }

    public void setFormacion(Formacion formacion) {
        this.formacion = formacion;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Personal{");
        sb.append("carnet=").append(carnet);
        sb.append(", colegio=").append(colegio);
        sb.append(", financiamiento=").append(financiamiento);
        sb.append(", funcion=").append(funcion);
        sb.append(", formacion=").append(formacion);
        sb.append(", apellidoMaterno=").append(apellidoMaterno);
        sb.append(", apellidoPaterno=").append(apellidoPaterno);
        sb.append(", braile=").append(braile);
        sb.append(", complemento=").append(complemento);
        sb.append(", correo=").append(correo);
        sb.append(", denominativo=").append(denominativo);
        sb.append(", direccionDomiciliaria=").append(direccionDomiciliaria);
        sb.append(", extranjero=").append(extranjero);
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append(", genero=").append(genero);
        sb.append(", nombres=").append(nombres);
        sb.append(", normalista=").append(normalista);
        sb.append(", nroCelular=").append(nroCelular);
        sb.append(", nroItem=").append(nroItem);
        sb.append(", rda=").append(rda);
        sb.append('}');
        return sb.toString();
    }



    public enum GeneroEnum {
        Masculino,
        Femenino
    }
}
