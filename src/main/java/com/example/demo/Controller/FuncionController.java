package com.example.demo.Controller;
import java.util.List;

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

import com.example.demo.Entity.Funcion;
import com.example.demo.Service.FuncionService;

@CrossOrigin
@RestController
@RequestMapping("api/funcion")
public class FuncionController {
    @Autowired
    FuncionService service;

    @GetMapping
    public ResponseEntity<List<Funcion>> get() {
        List<Funcion> lista = service.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcion> getEntity(@PathVariable Long id) {
        if (!service.existsById(id)) {  
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();         
        }

        Funcion registro = service.findById(id); 
        return ResponseEntity.ok(registro);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!service.existsById(id)) {  
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID not found");
        }
        service.deleteById(id); 
        return ResponseEntity.ok().body("Deleted successfully");
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Funcion> saveUsuario(@RequestBody Funcion x) {
        return ResponseEntity.ok(service.save(x));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcion> update(@PathVariable Long id, @RequestBody Funcion x) {
        if (!service.existsById(id)) {  
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();         
        }
        Funcion editad = service.findById(id);
        editad.setDescripcion(x.getDescripcion());
        editad.setNombre(x.getNombre());
        Funcion e = service.save(editad);
        return ResponseEntity.ok(e);
    }
}
