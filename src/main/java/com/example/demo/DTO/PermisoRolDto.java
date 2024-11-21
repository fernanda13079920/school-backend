package com.example.demo.DTO;

public class PermisoRolDto {
    private Long id;
    private Long idRol;
    private Long idPermiso;

    public PermisoRolDto(Long id,Long idRol, Long idPermiso) 
    {
        this.idPermiso = idPermiso;
        this.idRol = idRol;   
        this.id = id;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public Long getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Long idPermiso) {
        this.idPermiso = idPermiso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
