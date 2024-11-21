package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Permiso;
import com.example.demo.Service.PermisoService;

@CrossOrigin
@RestController
@RequestMapping("api/permiso")
public class PermisoController {
    @Autowired
    PermisoService service;

    @GetMapping
    public ResponseEntity<List<Permiso>> get() {
        List<Permiso> lista = service.findAll();
        return ResponseEntity.ok(lista);
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<Permiso> getEntity(@PathVariable Long id) {
    //     if (!service.existsById(id)) {  
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();         
    //     }

    //     Permiso registro = service.findById(id); 
    //     return ResponseEntity.ok(registro);
    // }
    
    // @DeleteMapping("/{id}")
    // public ResponseEntity<?> delete(@PathVariable Long id) {
    //     if (!service.existsById(id)) {  
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID not found");
    //     }
    //     service.deleteById(id); 
    //     return ResponseEntity.ok().body("Deleted successfully");
    // }

    // @PostMapping(path = "/save")
    // public ResponseEntity<Permiso> saveRegistro(@RequestBody Permiso x) {
    //     return ResponseEntity.ok(service.save(x));
    // }

    // @PutMapping("/{id}")
    // public ResponseEntity<Permiso> update(@PathVariable Long id, @RequestBody Permiso x) {
    //     if (!service.existsById(id)) {  
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();         
    //     }
    //     Permiso editad = service.findById(id);
    //     editad.setDescripcion(x.getDescripcion());
    //     editad.setNombre(x.getNombre());
    //     Permiso e = service.save(editad);
    //     return ResponseEntity.ok(e);
    // }
}
