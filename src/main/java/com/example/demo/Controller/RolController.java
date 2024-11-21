package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.RolDTO;
import com.example.demo.DTOresponse.rolResponse;
import com.example.demo.Entity.Rol;
import com.example.demo.Service.RolService;

@CrossOrigin
@RestController
@RequestMapping("api/rol")
public class RolController {
    @Autowired
    RolService service;

    @GetMapping
    public ResponseEntity<List<rolResponse>> get() {
        List<rolResponse> lista = service.obtenerRolesConPermisosAll();
        return ResponseEntity.ok(lista);
    }



    @GetMapping("/{id}")
    public ResponseEntity<rolResponse> getEntity(@PathVariable Long id) {
        Optional<Rol> registroOpt = service.findById(id);

        if (registroOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        rolResponse registro = service.obtenerRolConPermisos(id);
        return ResponseEntity.ok(registro);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Rol> registroOpt = service.findById(id);

        if (registroOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        

        service.deleteById(id); 
        return ResponseEntity.ok().body("Deleted successfully");
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Rol> saveRegistro(@RequestBody RolDTO x) {
        return ResponseEntity.ok(service.saveRol(x));
    }

    @PutMapping("/{id}")
    public ResponseEntity<rolResponse> update(@PathVariable Long id, @RequestBody RolDTO x) {
        rolResponse updatedRol = service.editRol(id, x);
        
        return ResponseEntity.ok(updatedRol);
    }
}
