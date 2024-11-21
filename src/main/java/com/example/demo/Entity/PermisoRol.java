package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rol_privilegio")
public class PermisoRol {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_privilegio", nullable=false)
    private Permiso permiso;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable=false)
    private Rol rol;

    public PermisoRol(Long id,Rol rol, Permiso permiso) {
        this.permiso = permiso;
        this.rol = rol;
        this.id = id;
    }

    public PermisoRol() {
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PermisoRol{");
        sb.append("permiso=").append(permiso);
        sb.append(", rol=").append(rol);
        sb.append('}');
        return sb.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
