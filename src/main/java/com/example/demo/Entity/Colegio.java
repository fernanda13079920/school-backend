package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "colegio")
public class Colegio {
    @Id
    private Integer codigo;
    private String area;
    private String canton;
    private String ciudad;
    private Integer codigoDistrito;
    private String departamento;
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    private String direccion;
    private String distrito;

    @Enumerated(EnumType.STRING)
    private EstadoEnum estado;


    private String nombre;
    private String provincia;
    private String seccionMunicipal;
    private String turno;
    private String zona;

    public Colegio() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getCodigoDistrito() {
        return codigoDistrito;
    }

    public void setCodigoDistrito(Integer codigoDistrito) {
        this.codigoDistrito = codigoDistrito;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public EstadoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoEnum estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getSeccionMunicipal() {
        return seccionMunicipal;
    }

    public void setSeccionMunicipal(String seccionMunicipal) {
        this.seccionMunicipal = seccionMunicipal;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Colegio{");
        sb.append("codigo=").append(codigo);
        sb.append(", area=").append(area);
        sb.append(", canton=").append(canton);
        sb.append(", ciudad=").append(ciudad);
        sb.append(", codigoDistrito=").append(codigoDistrito);
        sb.append(", departamento=").append(departamento);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", direccion=").append(direccion);
        sb.append(", distrito=").append(distrito);
        sb.append(", estado=").append(estado);
        sb.append(", nombre=").append(nombre);
        sb.append(", provincia=").append(provincia);
        sb.append(", seccionMunicipal=").append(seccionMunicipal);
        sb.append(", turno=").append(turno);
        sb.append(", zona=").append(zona);
        sb.append('}');
        return sb.toString();
    }


    
    public enum EstadoEnum {
        Abierta,
        Cerrada,
        Vacaciones_de_Fin_de_año,
        Vacaciones_de_invierno
    }
}



