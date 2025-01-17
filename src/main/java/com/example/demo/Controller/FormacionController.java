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

import com.example.demo.Entity.Formacion;
import com.example.demo.Service.FormacionService;

@CrossOrigin
@RestController
@RequestMapping("api/formacion")
public class FormacionController {
    @Autowired
    FormacionService service;

    @GetMapping
    public ResponseEntity<List<Formacion>> get() {
        List<Formacion> lista = service.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Formacion> getEntity(@PathVariable Long id) {
        if (!service.existsById(id)) {  
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();         
        }

        Formacion registro = service.findById(id); 
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
    public ResponseEntity<Formacion> saveUsuario(@RequestBody Formacion x) {
        return ResponseEntity.ok(service.save(x));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Formacion> update(@PathVariable Long id, @RequestBody Formacion x) {
        if (!service.existsById(id)) {  
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();         
        }
        Formacion editad = service.findById(id);
        editad.setDescripcion(x.getDescripcion());
        editad.setNombre(x.getNombre());
        Formacion e = service.save(editad);
        return ResponseEntity.ok(e);
    }
}
