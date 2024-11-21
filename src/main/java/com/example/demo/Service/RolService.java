package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.DTO.RolDTO;
import com.example.demo.DTOresponse.rolResponse;
import com.example.demo.Entity.Rol;

public interface RolService {
    List<Rol> findAll();

    Optional<Rol> findById(Long id);

    Rol save(Rol dia);

    void deleteById(Long id);

    boolean existsById(Long id);

    rolResponse obtenerRolConPermisos(Long rolId);
    
    List<rolResponse> obtenerRolesConPermisosAll();

    Rol saveRol(RolDTO rolDTO);

    rolResponse editRol(Long rolId, RolDTO rolDTO);
}
