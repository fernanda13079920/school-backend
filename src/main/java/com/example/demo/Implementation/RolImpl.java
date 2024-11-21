package com.example.demo.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.PermisoDTO;
import com.example.demo.DTO.RolDTO;
import com.example.demo.DTOresponse.rolResponse;
import com.example.demo.Entity.Permiso;
import com.example.demo.Entity.PermisoRol;
import com.example.demo.Entity.Rol;
import com.example.demo.Respository.PermisoRepository;
import com.example.demo.Respository.PermisoRolRepository;
import com.example.demo.Respository.RolRespository;
import com.example.demo.Service.RolService;

import jakarta.transaction.Transactional;

@Service
public class RolImpl implements  RolService {

    @Autowired
    RolRespository repository;

    @Autowired
    PermisoRepository permisoRespository;


    @Autowired
    PermisoRolRepository permisoRolRepository;
    @Override
    public List<Rol> findAll() {
        return repository.findAll();
    }

    @Override
    public Rol save(Rol dia) {
        return repository.save(dia);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Rol> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public rolResponse obtenerRolConPermisos(Long rolId) {
        // Obtener el Rol
        Rol rol = repository.findById(rolId)
        .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        // Obtener los permisos asociados al Rol
        List<PermisoRol> permisoRoles = permisoRolRepository.findByRolId(rolId);

        // Extraer los permisos como objetos PermisoDTO
        List<PermisoDTO> permisos = permisoRoles.stream()
            .map(pr -> new PermisoDTO(pr.getPermiso().getId(), pr.getPermiso().getNombre()))
            .collect(Collectors.toList());

        // Construir el rolResponse
        rolResponse rolResponse = new rolResponse();
        rolResponse.setId(rol.getId());
        rolResponse.setNombre(rol.getNombre());
        rolResponse.setDescripcion(rol.getDescripcion());
        rolResponse.setPermisos(permisos);

        return rolResponse;
    }

    @Override
    public List<rolResponse> obtenerRolesConPermisosAll() {
        // Obtener todos los roles
         List<Rol> roles = repository.findAll();

    // Construir una lista de rolResponse
    List<rolResponse> rolResponses = roles.stream().map(rol -> {
        // Obtener los permisos asociados al rol actual
        List<PermisoRol> permisoRoles = permisoRolRepository.findByRolId(rol.getId());

        // Extraer los datos de los permisos
        List<PermisoDTO> permisos = permisoRoles.stream()
                .map(pr -> new PermisoDTO(pr.getPermiso().getId(), pr.getPermiso().getNombre()))
                .collect(Collectors.toList());

        // Construir rolResponse para el rol actual
        rolResponse rolResponse = new rolResponse();
        rolResponse.setId(rol.getId());
        rolResponse.setNombre(rol.getNombre());
        rolResponse.setDescripcion(rol.getDescripcion());
        rolResponse.setPermisos(permisos);

        return rolResponse;
    }).collect(Collectors.toList());

    return rolResponses;
    }

    @Override
    public Rol saveRol(RolDTO rolDTO) {
        Rol rol = new Rol();
        rol.setNombre(rolDTO.getNombre());
        rol.setDescripcion(rolDTO.getDescripcion());

        // Guardar el rol en la base de datos
        rol = repository.save(rol);

        // Asociar permisos al rol usando idPermisos de RolDTO
        List<PermisoRol> permisoRoles = new ArrayList<>();
        for (Long idPermiso : rolDTO.getIdPermisos()) {
            Permiso permiso = permisoRespository.findById(idPermiso)
                    .orElseThrow(() -> new RuntimeException("Permiso no encontrado con ID: " + idPermiso));

            PermisoRol permisoRol = new PermisoRol();
            permisoRol.setRol(rol);
            permisoRol.setPermiso(permiso);
            permisoRoles.add(permisoRol);
        }

        // Guardar las relaciones PermisoRol en la base de datos
        permisoRolRepository.saveAll(permisoRoles);

        return rol;
    }

    @Transactional  // Asegura que este método tenga una transacción activa
    @Override
    public rolResponse editRol(Long rolId, RolDTO rolDTO) {
        // Buscar el Rol existente
        Rol rol = repository.findById(rolId)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        // Actualizar el nombre y descripción del Rol
        rol.setNombre(rolDTO.getNombre());
        rol.setDescripcion(rolDTO.getDescripcion());
        repository.save(rol);  // Guardar los cambios en el rol

        // Eliminar las asociaciones actuales de permisos
        permisoRolRepository.deleteByRolId(rolId);

        // Crear nuevas asociaciones de permisos usando los IDs del RolDTO
        List<PermisoRol> permisoRoles = new ArrayList<>();
        for (Long idPermiso : rolDTO.getIdPermisos()) {
            Permiso permiso = permisoRespository.findById(idPermiso)
                    .orElseThrow(() -> new RuntimeException("Permiso no encontrado con ID: " + idPermiso));

            PermisoRol permisoRol = new PermisoRol();
            permisoRol.setRol(rol);
            permisoRol.setPermiso(permiso);
            permisoRoles.add(permisoRol);
        }

        // Guardar las nuevas asociaciones de permisos
        permisoRolRepository.saveAll(permisoRoles);

        // Construir y devolver rolResponse
        List<PermisoDTO> permisos = permisoRoles.stream()
                .map(pr -> new PermisoDTO(pr.getPermiso().getId(), pr.getPermiso().getNombre()))
                .collect(Collectors.toList());

        rolResponse rolResponse = new rolResponse();
        rolResponse.setId(rol.getId());
        rolResponse.setNombre(rol.getNombre());
        rolResponse.setDescripcion(rol.getDescripcion());
        rolResponse.setPermisos(permisos);

        return rolResponse;
    }



}
